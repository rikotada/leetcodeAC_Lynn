package testTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSorting127 {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
	class DirectedGraphNode {
		      int label;
		      List<DirectedGraphNode> neighbors;
		      DirectedGraphNode(int x) {
		          label = x;
		         neighbors = new ArrayList<DirectedGraphNode>();
		     }
	 }
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        if(graph == null || graph.size() == 0){
             return result;
        }
        Map<DirectedGraphNode,Integer> map = new HashMap<>();
        Iterator<DirectedGraphNode> iterator = graph.iterator();
        while(iterator.hasNext()){
           DirectedGraphNode node = iterator.next();
           map.put(node,map.getOrDefault(node,0));
           for(DirectedGraphNode subNode:node.neighbors){
               map.put(subNode,map.getOrDefault(subNode,0)+1);
           }
        }
        Queue<DirectedGraphNode> q = new LinkedList<>();
        putZeroInNodes(q,map);
        while(!q.isEmpty()){
            DirectedGraphNode node = q.poll();
            result.add(node);
            reduceIn(node,map,q);
        }
        return result;
    }

    public void putZeroInNodes(Queue<DirectedGraphNode> q,Map<DirectedGraphNode,Integer> map){        
        Iterator<DirectedGraphNode> it = map.keySet().iterator();
        while(it.hasNext()){
            DirectedGraphNode node = it.next();
            if(map.get(node) == 0){
                q.offer(node);
                it.remove();
            }
        }
    }

    public void reduceIn(DirectedGraphNode node,Map<DirectedGraphNode,Integer> map,Queue<DirectedGraphNode> q){
        if(node.neighbors == null){
             return;
        }
        for(DirectedGraphNode subNode:node.neighbors){
           map.put(subNode,map.get(subNode) - 1);
           if(map.get(subNode) == 0){
              q.offer(subNode);
              map.remove(subNode);
           }
        }
        node.neighbors = null;
    }
}
