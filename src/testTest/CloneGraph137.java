package testTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraph137 {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
	class UndirectedGraphNode {
		  int label;
		  List<UndirectedGraphNode> neighbors;
		  UndirectedGraphNode(int x) {
		  label = x;
		  neighbors = new ArrayList<UndirectedGraphNode>();
		  }
	}
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if(node == null){
           return null;
        }
        Map<Integer,UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(node);
        visited.add(node.label);
        while(!q.isEmpty()){
            UndirectedGraphNode mainNode = q.poll();
            UndirectedGraphNode newNode = null;
            if(!map.containsKey(mainNode.label)){
               newNode = new UndirectedGraphNode(mainNode.label);
               map.put(mainNode.label,newNode);
            }
            else{
               newNode = map.get(mainNode.label);
            }           
            ArrayList<UndirectedGraphNode> list = new ArrayList<>();
            for(UndirectedGraphNode subNode:mainNode.neighbors){
                if(map.containsKey(subNode.label)){
                   list.add(map.get(subNode.label));
                }
                else{
                    UndirectedGraphNode newSub = new UndirectedGraphNode(subNode.label);
                    map.put(subNode.label,newSub);
                    list.add(newSub);
                }
                if(!visited.contains(subNode.label)){
                   q.offer(subNode);
                }
                visited.add(subNode.label); 
            }
            newNode.neighbors = list;
        }
        return map.get(node.label);
    }
}
