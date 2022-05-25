package testTest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestSumInTwoSortedArrays {
    /**
     * @param A: an integer arrays sorted in ascending order
     * @param B: an integer arrays sorted in ascending order
     * @param k: An integer
     * @return: An integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here
        if(A == null || B == null){
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2){
                 return o2-o1;
            }
        });
        int a = A.length - 1;
        int b = B.length - 1;
        int aPointer = 0,bPointer = 0;
        for(int i = 0;i <= a;i++){
            for(int j = 0;j <= b;j++){
                int sum = A[i] +B[j];
                pq.add(sum);
                if(pq.size() > k){
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}
