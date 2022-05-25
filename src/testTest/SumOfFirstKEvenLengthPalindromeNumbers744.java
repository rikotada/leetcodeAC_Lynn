package testTest;

public class SumOfFirstKEvenLengthPalindromeNumbers744 {
    /**
     * @param k: Write your code here
     * @return: the sum of first k even-length palindrome numbers
     */
    public int sumKEven(int k) {
        if(k == 0){
          return 0;
        }
        int i = 1;
        int result = 0;
        while(i <= k){
           String s = new String(i+"");
           char[] num = s.toCharArray();
           StringBuilder sb = new StringBuilder();
           for(int m = num.length - 1;m >= 0;m--){
              sb.append(num[m]);
           }
           String s2 = sb.toString();
           s = s + s2;
    
           result += Integer.parseInt(s);
           i++;
           
        }
        return result;
         
    }
}
