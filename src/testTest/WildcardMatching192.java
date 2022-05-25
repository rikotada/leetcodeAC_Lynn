package testTest;

public class WildcardMatching192 {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if(s.equals("") && p.equals("")){
            return  true;
        }
        if(p.equals("*")){
            return true;
        }
        int sLength = s.length();
        int pLength = p.length();
        boolean[][] dp = new boolean[sLength+1][pLength+1];
        dp[0][0] = true;
        //如果开头是*那么初始设置前0个字符串可以匹配前1个*
        if(p.charAt(0) == '*'){
            dp[0][1] = true;
        }
        for(int i = 1; i < sLength+1; i++){
            for(int j = 1;j < pLength+1; j++){
                if(p.charAt(j-1) == '*'){
                    //如果第二个字符串的最后一个是*
                    //要么*为空 前i个匹配j-1个
                    //要么*为不为空的任意 这种情况下dp[i-1][j]代表了前0~i-1个数和j的匹配情况
                    dp[i][j] = (dp[i-1][j] || dp[i][j-1]);
                }
                else if(p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    boolean a = s.charAt(i-1) == 
                                p.charAt(j-1) ? true : false;
                    dp[i][j] = dp[i-1][j-1] && a;
                }
            }
        }
        return dp[sLength][pLength];
    }
}
