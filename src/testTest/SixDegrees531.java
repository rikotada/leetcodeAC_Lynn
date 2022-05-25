package testTest;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SixDegrees531 {
    /*
     * @param graph: a list of Undirected graph node
     * @param s: Undirected graph node
     * @param t: Undirected graph nodes
     * @return: an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        // write your code here
        if(s.neighbors == null || t.neighbors == null){
             return -1;
        }
        if(s.equals(t)){
           return 0;
        }
        int result = 1;
        Queue<UndirectedGraphNode> q = new ArrayDeque<>();
        q.offer(s);
        Set<UndirectedGraphNode> visited = new HashSet<>();
        visited.add(s);
        while(!q.isEmpty()){
             int size = q.size();
             for(int i = 0;i < size;i++){
                 UndirectedGraphNode node = q.poll();
                 for(UndirectedGraphNode subNode: node.neighbors){
                     if(subNode.equals(t)){
                         return result;
                     }
                     if(!visited.contains(subNode)){
                         q.offer(subNode);
                         visited.add(subNode);
                     }
                 }
             }
             result++;
             
        }
        return -1;
    }
}
