package testTest;

public class DecodeWays512{
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // write your code here
        if(s.equals("") ||s == null){
            return 0;
        }
        int length = s.length();
        int[] dp = new int[length+1];
        dp[0] = 1;
        for(int i = 1;i < length+1;i++){
            int twoDigit = 0;
            int oneDigit = 0;
            if(i >= 2 && decodeable(s.substring(i-2,i))){
                twoDigit = 1;
                dp[i] = dp[i-2] * twoDigit;
            }
            if(decodeable(s.substring(i-1,i))){
                oneDigit = 1;
            }
            dp[i] = dp[i] + dp[i-1] * oneDigit;
        }
        return dp[length];
    }
    public boolean decodeable(String sub){
        if(sub.charAt(0) == '0'){
            return false;
        }
        int a = Integer.parseInt(sub);
        if(a >= 1 && a <= 26){
            return true;
        }
        return false;
    }
}
