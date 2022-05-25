package testTest;

public class GrumpyBookstoreOwner1849 {
    /**
     * @param customers: the number of customers
     * @param grumpy: the owner's temper every day
     * @param X: X days
     * @return: calc the max satisfied customers
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int x) {
        // write your code here
        if(customers == null || customers.length == 0){
              return 0;
        }
        int result = 0;
        int maxget = 0;
        int len = customers.length;
        for(int m = 0;m < x;m++){
            if(grumpy[m] == 1){
                maxget += customers[m];
            }
        }
        int intervalget = maxget;
        for(int i = 0;i < len;i++){
           if(grumpy[i] == 0){
               result += customers[i];
           }          
           if(i > 0){
              if(grumpy[i - 1] == 1){
                intervalget -= customers[i - 1];
              }
              if(i + x - 1 < len && grumpy[i + x - 1] == 1){
                 intervalget += customers[i + x - 1];
              }
              maxget = Math.max(maxget,intervalget);
           }
        }
        return maxget + result;
    }
}
