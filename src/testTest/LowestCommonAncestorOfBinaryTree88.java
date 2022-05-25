package testTest;

import java.util.ArrayDeque;
import java.util.Queue;

public class LowestCommonAncestorOfBinaryTree88 {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root == null){
           return null;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        int depth = 1;
        int maxDepth = Integer.MIN_VALUE;
        TreeNode result = null;
        q.offer(root);
        while(!q.isEmpty()){
           int size = q.size();
           boolean find  = false;
           for(int i = 0;i < size;i++){
              TreeNode node = q.poll();
              if(ifSubTree(node,A) && ifSubTree(node,B) && depth > maxDepth){
                 maxDepth =  depth;
                 find = true;
                 result = node;
                 if(node.left != null){
                    q.offer(node.left);
                 }
                 if(node.right != null){
                    q.offer(node.right);
                 } 
                 break;
              }                         
           }
           if(!find){
             break;
           }
           depth++;
        }
        return result;
    }
    
    public boolean ifSubTree(TreeNode root,TreeNode node){
         if(root == null){
            return false;
         }
         if(root.val == node.val){
            return true;
         }
         return (ifSubTree(root.left,node) || ifSubTree(root.right,node));
    }
}
