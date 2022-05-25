package testTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalOrderTraversalOfBinaryTree987  {
    class NodeWithCol{
        TreeNode node;
        int col;
        public NodeWithCol(TreeNode node,int col){
           this.node = node;
           this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<NodeWithCol> q = new ArrayDeque<>();
        Map<Integer,List<Integer>> map = new HashMap<>();

        int left = 0;
        int right = 0;

        q.offer(new NodeWithCol(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            Map<Integer,List<Integer>> layer = new HashMap<>();
            for(int i = 0;i < size;i++){
               NodeWithCol nodeWithCol = q.poll();
               TreeNode node = nodeWithCol.node;
               int col = nodeWithCol.col;
               left = Math.min(left,col);
               right = Math.max(right,col);
               List<Integer> subList = null;
               if(!layer.keySet().contains(col)){
                  subList = new ArrayList<>();
                  layer.put(col,subList);
               }
               else{
                   subList = layer.get(col);
               }
               subList.add(node.val);
               if(node.left != null){
                  q.offer(new NodeWithCol(node.left,col - 1));
               }
               if(node.right != null){
                   q.offer(new NodeWithCol(node.right, col + 1));
               }
            }
            for(int key : layer.keySet()){
                Collections.sort(layer.get(key));
                if(!map.keySet().contains(key)){                  
                   List<Integer> r = new ArrayList<>(layer.get(key));
                   map.put(key,r);
                }
                else{
                   List<Integer> r = map.get(key);
                   r.addAll(layer.get(key));
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = left;i <= right;i++){
            result.add(map.get(i));
        }
        return result;

    }
}