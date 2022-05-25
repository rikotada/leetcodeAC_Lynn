package testTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumOperationsToHalveArraySum2208 {
    public int halveArray(int[] nums) {
        int len = nums.length;
        long sum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i < len;i++){
           pq.offer(nums[i] + 0.0);
           sum += nums[i];
        }
        double cut = 0;
        double threshold = sum / 2.0;
        int time = 0;
        while(cut < threshold){
           double n = pq.poll();
           n = n / 2.0;
           cut += n;
           pq.offer(n);
           time++;
        }
        return time;
    }
}