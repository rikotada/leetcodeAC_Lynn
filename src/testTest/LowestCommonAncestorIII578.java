package testTest;

import java.util.ArrayDeque;
import java.util.Queue;

public class LowestCommonAncestorIII578 {
  
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        if(root == null){
            return null;
        }
        if(isValid(root,A) == false || isValid(root,B) == false){
            return null;
        }
        return LCA(root,A,B);
    }

    public TreeNode LCA(TreeNode root,TreeNode A, TreeNode B){
        if(root == null){
           return null;
        }
        if(root.val == A.val){
           return A;
        }
        if(root.val == B.val){
           return B;
        }
        TreeNode nodeL = LCA(root.left,A,B);
        TreeNode nodeR = LCA(root.right,A,B);
        if((nodeL == A && nodeR == B)||
           (nodeL == B && nodeR == A)){
           return root;
        }
        if(nodeR != null){
           return nodeR;
        }
        if(nodeL != null){
          return nodeL;
        }
        return null;
    }



    public boolean isValid(TreeNode root,TreeNode child){
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
