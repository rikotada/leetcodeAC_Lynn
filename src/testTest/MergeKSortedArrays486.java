package testTest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays486 {
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        if(arrays == null || arrays.length == 0){
             return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
               return a - b;
            }
        });
        int count = 0;
        for(int i = 0;i < arrays.length;i++){          
            for(int k = 0;k < arrays[i].length;k++){
                count++;
               pq.offer(arrays[i][k]);
            }
        }
        int[] result = new int[count];
        int j = 0;
        while(!pq.isEmpty()){
            result[j] = pq.poll();
            j++;
        }

        return result;
    }
}
