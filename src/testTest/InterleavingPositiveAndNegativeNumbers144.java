package testTest;

public class InterleavingPositiveAndNegativeNumbers144 {
    /*
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
        // write your code here
        if(A == null|| A.length <= 1){
            return;
        }
        int n = A.length;
        int positive = 0;
        int negative = 0;
        int firstPositiveIndex = -1;
        int firstNegativeIndex = -1;
        if(n % 2 == 1){
           for(int i = 0;i < n;i++){
               if(A[i] > 0){
                   if(firstPositiveIndex < 0){
                       firstPositiveIndex = i;
                   }
                   positive++;
               }
               if(A[i] < 0){
                   if(firstNegativeIndex < 0){
                       firstNegativeIndex = i;
                   }
                   negative++;
               }
           }
           if(positive > negative && A[0] < 0){
              int temp = A[0];
              A[0] = A[firstPositiveIndex];
              A[firstPositiveIndex] = temp;
           }
           else if(positive < negative && A[0] > 0){
               int temp = A[0];
               A[0] = A[firstNegativeIndex];
               A[firstNegativeIndex] = temp;
           }
        }

        int left = 0;
        int right = 1;
        while(right < n){
            boolean moved = false;
            while(right < n && A[left] * A[right] > 0){
                moved = true;
                right++;
            }
            if(right < n && moved){
               int temp = A[right];
               A[right] = A[left + 1];
               A[left + 1] = temp;
            }
            if( right < n && A[left] *A[right] < 0){
                  left = left + 1;
                  right = left + 1;
            }

          
        }
        return;
    }
}
