package testTest;

import java.util.ArrayList;
import java.util.List;

public class DivideTwoIntegers414 {
    /**
     * @param dividend: the dividend
     * @param divisor: the divisor
     * @return: the result
     */
    public int divide(int dividend, int divisor) {
        // write your code here
        long a = dividend;
        long b = divisor;

        if(dividend == 0){
           return 0;
        }
        if(divisor == 0){
           return dividend > 0 ? Integer.MAX_VALUE : Integer.MAX_VALUE *  -1;
        }
        if(dividend == divisor){
             return 1;
        }
        if(Math.abs(b) == 1){
           if(dividend == Integer.MIN_VALUE){
              return divisor > 0 ? dividend:Integer.MAX_VALUE;
           }
           return divisor > 0 ? dividend :  (0 - dividend);
        }
        
        long positiveDividend = Math.abs(a);
        long positiveDivisor = Math.abs(b);
        List<Long> powers = new ArrayList<>();
        while(positiveDivisor <= positiveDividend ){
           powers.add((long)positiveDivisor);
           positiveDivisor += positiveDivisor;
        }
        if(powers.size() == 0){
             return 0;
        }
        int result = (int)helper(positiveDividend,Math.abs(divisor),powers);
        boolean same = true;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
              same = false;
        }
        return same ? result : (0 - result);
    }

    public long helper(long dividend,long divisor,List<Long> powers){
        if(dividend < divisor){
            return 0;
        }
        int times = 0;
        long originalDivisor = divisor;
        int left = 0;
        int right = powers.size() - 1;
        if(powers.get(right) < dividend){
            times = right;
        }
        else{
            while(left + 1 < right){
                long mid = powers.get((left + right) / 2);
                if(mid > dividend){
                    right = (left + right) / 2;
                }
                else{
                    left = (left + right) / 2;
                }
            }
            times = left;
        }
        
        int powerTwo = 1;
        while(times > 0){
           powerTwo += powerTwo;
           divisor += divisor;
           times--;
        }
        
        return (long)(powerTwo + helper(dividend - divisor,originalDivisor,powers));
    }
}
