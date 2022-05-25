package testTest;

public class InterestingString1630 {
    /**
     * @param s: the string s
     * @return: check if the string is interesting
     */
    String result = "no";
    public String check(String s) {
        // Write your code here
        if(s == null || s.length() == 0){
           return "yes";
        }
        int n = s.length();
        int i = 0;
        while(i < n){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                i = i + Integer.parseInt(Character.toString(c)) + 1;
            }
            else{
                break;
            }
        }
        if(i == n){
           return "yes";
        }
        dfs(s,0);
        return result;

        
    }


    public void dfs(String s,int index){
        if(index == s.length()){
             result = "yes";
             return;
         }
         if(index > s.length() || !isNum(s,index) || result.equals("yes")){
             return;
         }
         
         int originalIndex = index;
         while(isNum(s,index)){
            dfs(s,index + 1 + Integer.parseInt(s.substring(originalIndex, index + 1)));
            index++;
         }
         return;

    }

    public boolean isNum(String s,int index){
        if(s.charAt(index) >= '0' && s.charAt(index) <= '9'){
              return true;
        }
        return false;
    }
}
