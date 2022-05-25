package testTest;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DirectedGraphLoop1366 {
    /**
     * @param start: The start points set
     * @param end: The end points set
     * @return: Return if the graph is cyclic
     */
    public boolean isCyclicGraph(int[] start, int[] end) {
        // Write your code here
        if(start.length == 0 || end.length == 0 || start.length != end.length){
            return false;
        }
        Map<Integer,Set<Integer>> map = new HashMap<>();
        Map<Integer,Integer> indegree = new HashMap<>();
        Set<Integer> vertexs = new HashSet<>();
        int size = start.length;
        for(int i = 0;i < size;i++){
           vertexs.add(start[i]);
           vertexs.add(end[i]);
           if(map.keySet().contains(start[i])){
               map.get(start[i]).add(end[i]);
           }
           else{
               HashSet<Integer> set = new HashSet<>();
               set.add(end[i]);
               map.put(start[i],set); 
           }
            indegree.put(end[i],indegree.getOrDefault(end[i], 0) + 1);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(Integer vertex:vertexs){
            if(!indegree.keySet().contains(vertex)){
               q.offer(vertex);
            }
        }

        if(q.isEmpty()){
            return true;
        }
        
        while(!q.isEmpty()){
            Integer v = q.poll();
            vertexs.remove(v);
           
            Set<Integer> toPoints = new HashSet<>();
            if(map.keySet().contains(v)){
               toPoints = map.get(v);
            }
            
            for(Integer tp:toPoints){
                indegree.put(tp,indegree.get(tp) - 1);
                if(indegree.get(tp) == 0){
                   q.offer(tp);
                }
            }
        }
        
       
        return vertexs.size() == 0 ? false:true;
    }
}
