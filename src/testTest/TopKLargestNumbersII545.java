package testTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class TopKLargestNumbersII545 {
    /*
    * @param k: An integer
    */
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
        public int compare(Integer o1,Integer o2){
           return o1-o2;
        }
    });

    int size;
    Integer min = Integer.MAX_VALUE;
    public TopKLargestNumbersII545(int k) {
        // do intialization if necessary
        size = k;
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        if(num <= min && pq.size() >= size){
             return;
        }
        if(pq.size() >= size){
            pq.poll();            
        }
        pq.offer(num);
        min = pq.peek();
        
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
        int l = Math.min(size,pq.size());
        int i = 0;
        List<Integer> result = new ArrayList<>();
        Iterator<Integer> it = pq.iterator();
        while(it.hasNext() && i < l){
           result.add(it.next());
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}
