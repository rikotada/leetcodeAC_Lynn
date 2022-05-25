package testTest;

import java.util.ArrayDeque;
import java.util.Queue;

public class UnivaluedBinaryTree965 {
    public boolean isUnivalTree(TreeNode root) {
           int val = root.val;
           Queue<TreeNode> q = new ArrayDeque<>();
           q.offer(root);
           while(!q.isEmpty()){
               TreeNode node = q.poll();
               if(node.val != val){
                  return false;
               }
               if(node.left != null){
                  q.offer(node.left);
               }
               if(node.right != null){
                  q.offer(node.right);
               }
           }
           return true;
    }
}
