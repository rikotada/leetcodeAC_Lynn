package testTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal71 {
    /**
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
           return result;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean leftToRight = true;
        while(!q.isEmpty()){
            int size = q.size();
            int i = 0;
            List<Integer> sub = new ArrayList<>();
            while(i < size){
                TreeNode node = q.poll();
                sub.add(node.val);
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }   
                i++;        
            }
            if(!leftToRight){
              Collections.reverse(sub);
            }
            result.add(sub);
            leftToRight = !leftToRight;

        }
        return result;
    }
}
