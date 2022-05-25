package testTest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream81 {
    /**
     * @param val: a num from the data stream.
     * @return: nothing
     */

    PriorityQueue<Integer> greater = new PriorityQueue<>();
    //with nums larger than mid
    PriorityQueue<Integer> less = new PriorityQueue<>(new Comparator<Integer>(){
          public int compare(Integer o1,Integer o2){
             return o2-o1;
		}
    });
    //with nums less than mid
    int pointer = Integer.MIN_VALUE;
    int num = 0;
    boolean added = false;
    public void add(int val) {
        // write your code here
	   num++;
	   if(added){
            if(num % 2 == 0 && val >= pointer){
               greater.add(val);
            }
            else if(num % 2 == 0 && val < pointer){
               greater.add(pointer);
               less.add(val);
               pointer = less.poll();
            }
            else if(num % 2 == 1 && val >= pointer){
                 less.add(pointer);
                 greater.add(val);
                 pointer = greater.poll();
            }
            else{
                less.add(val);
            }
	   }
	   else{
           added = true;
		   pointer = val;
	   }
	   
    }

    /**
     * @return: return the median of the all numbers
     */
    public int getMedian() {
        // write your code here
	   return pointer;
    }
}
