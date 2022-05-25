package testTest;

import java.util.ArrayDeque;
import java.util.Queue;

public class LowestCommonAncestorOfBinarySearch1311 {
    /**
     * @param root: root of the tree
     * @param p: the node p
     * @param q: the node q
     * @return: find the LCA of p and q
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // write your code here
        if(root == null){
             return  null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        TreeNode result = root;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
               TreeNode node = queue.poll();
               result = node;
               if(node.left != null){
                   if(hasChild(node.left,p) && hasChild(node.left,q)){
                      queue.offer(node.left);
                  }
               }
               if(node.right != null){
                   if(hasChild(node.right,p) && hasChild(node.right,q)){
                      queue.offer(node.right);
                  }
               }
               
            }
        }
        return result;
    }

    public boolean hasChild(TreeNode root, TreeNode child){
          Queue<TreeNode> q = new ArrayDeque<>();
          q.offer(root);
          while(!q.isEmpty()){
              TreeNode node = q.poll();
              if(node.val == child.val){
                  return true;
              }
              if(node.left != null){
                   q.offer(node.left);
              }
              if(node.right != null){
                   q.offer(node.right);
              }
          }
          return false;
    }
}
