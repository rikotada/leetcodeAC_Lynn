package testTest;

import java.util.LinkedList;
import java.util.Queue;

public class TrimBinarySearchTree {
    /**
     * @param root: given BST
     * @param minimum: the lower limit
     * @param maximum: the upper limit
     * @return: the root of the new tree 
     */
    public TreeNode trimBST(TreeNode root, int min, int max) {
        // write your code here
        if(root == null){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode newRoot = new TreeNode(0);
        q.offer(root);

        while(!q.isEmpty()){
             TreeNode node = q.poll();
             if(node.val <= max && node.val >= min && newRoot.right == null){
                 newRoot.right = node;
             }
             if(node.left != null){
                if(node.left.val < min && node.left.right == null){
                    node.left = null;
                }
                else if(node.left.val < min &&  node.left.right != null){
                    node.left = node.left.right;
                    TreeNode a = node.left;
                    while(a != null && a.val < min){
                        a = a.right;
                    }
                    if(a != null){
                       q.offer(a); 
                    }
                    node.left = a;
                }
                else if(node.left.val >= min){
                    q.offer(node.left);
                }
             }
              if(node.right != null){
                if(node.right.val > max && node.right.left == null){
                    node.right = null;
                }
                else if(node.right.val > max &&  node.right.left != null){
                    node.right = node.right.left;
                    TreeNode b = node.right;
                    while(b != null && b.val > max){
                        b = b.left;
                    }
                    if(b != null){
                       q.offer(b); 
                    }
                    node.right = b;
                }
                else if(node.right.val <= max){
                    q.offer(node.right);
                }
             }
        }
        return newRoot.right;
    }
    
    //若根节点的值小于最小值，则递归调用右子树并返回右子树；
    //若根节点的值大于最大值，则递归调用左子树并返回左子树；
    //否则修剪左子树，右子树并返回根节点。
    public TreeNode trimBST2(TreeNode root, int minimum, int maximum) {
        // write your code here
        if (root == null)  {
            return null;
        }
        
        if (root.val < minimum) {
            return trimBST2(root.right, minimum, maximum);
        } else if (root.val > maximum) {
            return trimBST2(root.left, minimum, maximum);
        } else {
            root.left = trimBST2(root.left, minimum, maximum);
            root.right = trimBST2(root.right, minimum, maximum);
        }

        return root;
    }
    
}
