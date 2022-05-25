package testTest;

public class PowXN428 {
    /**
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        // write your code here
        if(n == 0){
            return 1;
        }
        if(x == 0.0){
            return 0;
        }
        Object o1 = null;
        

        return power(x,n);
        
    }

    public double power(double x,int i){
       if(i == 1){
          return x;
       }
       if(i == -1){
         return 1.0 / x;
       }
       double a =  power(x,i / 2);
       if(Math.abs(i % 2) == 1){         
          return i > 0 ? x * a * a : a * a / x;
       }
       return a * a;
    }
}
