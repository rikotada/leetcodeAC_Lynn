package testTest;

public class RegularExpressionMatching154 {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if(s.equals(p)){
            return true;
        }
        if(s == "" && p == "*"){
            return true;
        }
        if(s == ""){
            return false;
        }
        int a = s.length();
        int b = p.length();
        boolean dp[][] = new boolean[a+1][b+1];
        dp[0][0] = true; 
        //.*在开头的特殊情况处理  
        if(b >= 2 && p.charAt(1) == '*'){
             dp[0][2] = true;
        }
        for(int i = 1; i <= a;i++){
            for(int j = 1; j <= b;j++){
                if(p.charAt(j-1) == '*' && p.charAt(j-2) == '.'){
                    //f表示 *变成n个点
                    boolean f = false;
                    for(int g = i-1; g >= -1;g--){
                       if(dp[g+1][j-2]){
                           f = true;
                           break;
                       }
                    }
                    //dp[i][j-2] 表示*变成“”
                    dp[i][j] = (f || dp[i][j-2]);
                }
                else if(p.charAt(j-1) == '*' && p.charAt(j-2) != '.'){
                    //h表示把n个前置字母缩减成一个的位置（不包含空所以前置特殊处理）
                    int h = continueNum(s,i);
                    dp[i][j] = (dp[h][j-1] || dp[i][j-2]);
                }
                else if(p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    boolean c = (p.charAt(j-1) == s.charAt(i-1)) ? true : false;
                    dp[i][j] = (dp[i-1][j-1] && c);
                }
            }
        }
        return dp[a][b];
    }
     public int continueNum(String s, int i){
         while(i >= 2 && s.charAt(i-1) == s.charAt(i-2)){
               i--;
         }
         return i;
     }
}