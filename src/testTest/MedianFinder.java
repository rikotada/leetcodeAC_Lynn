package testTest;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    int added = 0;
    double median = 0.0;
    PriorityQueue<Integer> smaller;
    PriorityQueue<Integer> larger;

    public MedianFinder() {
        smaller = new PriorityQueue<>(Collections.reverseOrder());
        larger = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
       if(added == 0){
           median = num + 0.0;
       }
       else{
          if(added % 2 == 0){
              if(num >= median){
                   larger.offer(num);
                   median = larger.poll() + 0.0;
              }
              else{
                  smaller.offer(num);
                  median = smaller.poll() + 0.0;
              }
          }
          else{
              if(num >= median){
                  smaller.offer((int)median);
                  larger.offer(num);
              }
              else{
                  larger.offer((int)median);
                  smaller.offer(num);
              }
              median = (smaller.peek() + larger.peek()) / 2.0;
          }
       }
       added++;
    }
    
    public double findMedian() {
          return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
