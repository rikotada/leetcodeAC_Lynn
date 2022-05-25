package testTest;

import java.util.ArrayDeque;
import java.util.Queue;

public class LowestCommonAncestorII474  {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here
        if(root == null){
           return null;
        }
        Queue<ParentTreeNode> q = new ArrayDeque<>();
        q.offer(A);
        while(!q.isEmpty()){
            ParentTreeNode node = q.poll();
            if(hasChild(node,B)){
                return node;
            }
            if(node.parent != null){
               q.offer(node.parent);
            }
            
        }
        return null;
    }

    public boolean hasChild(ParentTreeNode root,ParentTreeNode child){
    	
        Queue<ParentTreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            ParentTreeNode node = q.poll();
            if(node == child){
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
