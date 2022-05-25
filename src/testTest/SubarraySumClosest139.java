package testTest;

import java.util.Arrays;
import java.util.Comparator;

public class SubarraySumClosest139 {
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */

    class Point{
        int prefix;
        int index;
        public Point(int prefix,int index){
            this.prefix = prefix;
            this.index = index;
        }
    }
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] result = new int[2];
        if(nums == null || nums.length == 0){
            return result;
        }
        int len = nums.length;
        Point[] arr = new Point[len];
        arr[0] = new Point(nums[0],0);
        int minIndex = Integer.MIN_VALUE;
        int close = Integer.MAX_VALUE;
        for(int i = 1;i < len;i++){
           if(Math.abs(nums[i]) < close ){
               close = Math.abs(nums[i]);
               minIndex = i;
           }                     
           if(nums[i] == 0){
              result[0] = i;
              result[1] = i;
              return result;
           }
           int prefix = arr[i - 1].prefix + nums[i];
           if(prefix == 0){
              result[0] = 0;
              result[1] = i;
              return result;
           }
           arr[i] = new Point(prefix,i);               
        }
        Arrays.sort(arr, new Comparator<Point>(){
            public int compare(Point o1,Point o2){
                return o1.prefix - o2.prefix;
            }
        });

        int diff = Integer.MAX_VALUE;

        for(int i = 0;i < len - 1;i++){
           int a = arr[i].prefix;
           int b = arr[i + 1].prefix;
           if(b - a < diff){
              diff = b - a;
              result[0] = Math.min(arr[i].index,arr[i + 1].index) + 1;
              result[1] = Math.max(arr[i].index,arr[i + 1].index);
           }
           if(Math.abs(a) < diff){
                diff = Math.abs(a);
                result[0] = 0;
                result[1] = i;
           }
        }

        if(Math.abs(arr[len - 1].prefix) < diff){
             diff = Math.abs(arr[len - 1].prefix);
             result[0] = 0;
             result[1] = len - 1;
        }

        if(diff > close){
            result[0] = minIndex;
            result[1] = minIndex;
        }
       
        return result;
    }
}
