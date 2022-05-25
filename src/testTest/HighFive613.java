package testTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive613 {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        int n = results.length;
        System.out.println(n);
        for(int i = 0;i < n;i++){
            Record r = results[i];
            PriorityQueue<Integer> q = null;
            if(map.get(r.id) == null){
                q = new PriorityQueue<>();
                q.offer(r.score);
                map.put(r.id,q);
            }
            else{
                q = map.get(r.id);
                q.offer(r.score);
                if(q.size() > 5){
                    q.poll();
                }
            }
        }
        Map<Integer,Double> result = new HashMap<>();
        for(Integer key:map.keySet()){
             PriorityQueue queue = map.get(key);
             int sumScore = 0;
             int entries = queue.size();
             Iterator it = queue.iterator();
             while(it.hasNext()){
                sumScore += (Integer)it.next();
             }
             double score = sumScore * 1.0/ entries;
             result.put(key,score);
        }
        return result;
    }
}
