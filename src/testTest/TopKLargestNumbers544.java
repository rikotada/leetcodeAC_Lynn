package testTest;

import java.util.PriorityQueue;

public class TopKLargestNumbers544 {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // write your code here
        if(nums == null || nums.length == 0 || k == 0){
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i < nums.length;i++){
            if(pq.size() < k || nums[i] > pq.peek()){
                 pq.offer(nums[i]);
            }
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] result = new int[k];
        for(int m = k -1 ;m >= 0;m-- ){
            result[m] = pq.poll();
        }
        return result;
    }
}
