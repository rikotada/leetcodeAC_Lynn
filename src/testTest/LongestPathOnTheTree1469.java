package testTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class LongestPathOnTheTree1469 {
    /**
     * @param n: The number of nodes
     * @param starts: One point of the edge
     * @param ends: Another point of the edge
     * @param lens: The length of the edge
     * @return: Return the length of longest path on the tree.
     */
    int result = 0;
    class Node{
        int num;
        int accum;
        List<Node> neighbor = new ArrayList<>();
        List<Integer> len = new ArrayList<>();

    }
    public int longestPath(int n, int[] starts, int[] ends, int[] lens) {
        // Write your code here
        if(n <= 1 || starts.length == 0){
            return 0;
        }
        int l = starts.length;
        Node[] arr = new Node[n];
        for(int i = 0;i < l;i++){
            Node nodeS = null;
            Node nodeE = null;
            int a = starts[i];
            int b = ends[i];
           if(arr[a] == null){
               arr[a] = new Node();
               arr[a].num = a;
           }          
           nodeS = arr[a];          
           if(arr[b] == null){
               arr[b] = new Node();
               arr[b].num = b; 
           }
           nodeE = arr[b];
           List<Node> listS = nodeS.neighbor;
           listS.add(nodeE);
           nodeS.len.add(lens[i]);          
           List<Node> listE = nodeE.neighbor;
           listE.add(nodeS);
           nodeE.len.add(lens[i]);
        }
        
        Queue<Node> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        q.offer(arr[0]);
        visited.add(arr[0].num);
        Node z = null;
        int far = 0;
        while(!q.isEmpty()){
            Node node = q.poll();
            System.out.println(node.num);
            List<Node> list = node.neighbor;
            List<Integer> len = node.len;
            int length = list.size();
            for(int i = 0;i < length;i++){
                Node subNode = list.get(i);
                if(visited.contains(subNode.num)){
                   continue;
                }
                subNode.accum = node.accum + len.get(i);
                q.offer(subNode);
                visited.add(subNode.num);
                if(subNode.accum > far){
                    z = subNode;
                    far = subNode.accum;
                }
            }
        }

        visited.clear();
        z.accum = 0;
        q.offer(z);
        visited.add(z.num);
        while(!q.isEmpty()){
            Node node = q.poll();              
            List<Node> list = node.neighbor;
            List<Integer> len = node.len;
            int length = list.size();
            for(int i = 0;i < length;i++){
                Node subNode = list.get(i);
                if(visited.contains(subNode.num)){
                   continue;
                }
                subNode.accum = node.accum + len.get(i);
                q.offer(subNode);
                visited.add(subNode.num);
                if(subNode.accum > far){
                    z = subNode;
                    far = subNode.accum;
                }
            }
        }

        return far;
    }

}
