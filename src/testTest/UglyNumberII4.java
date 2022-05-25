package testTest;

public class UglyNumberII4 {
    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here
        long[] dp = new long[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for(int i = 1;i < n ;i++){
           long next = Math.min(2*dp[p2],Math.min(3*dp[p3],5*dp[p5]));
           if(next == dp[p2]*2){
              p2++;
           }
           if(next == dp[p3]*3){
              p3++;
           }
           if(next == dp[p5]*5){
              p5++;
           }
           dp[i] = next;
        }
        return (int)dp[n-1];
    }

}
