package testTest;

public class KthSmallestNumberInMultiplicationTable668 {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        while(left  + 1 < right){
           int mid = (right - left) / 2 + left;
           int lessAndEqual = lessOrEqual(mid,m,n);
           if(lessAndEqual  >= k){
                right = mid;
           }
           else{
               left = mid;
           }
        }
        if(lessOrEqual(left,m,n) == k){
            return left;
        }
        return right;


    }

    public int lessOrEqual(int mid,int m,int n){
         int result = 0;
         int i = 1;
         while(i <= n ){
            int num = Math.min(mid / i, m);
            if(num == 0){
               return result;
            }
            result += num;
            i++;
         }
         return result;
    }


}
