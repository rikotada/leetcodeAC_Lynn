package testTest;

public class FlattenBinaryTreeToLinkedList453 {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
       traverse(root);
    }

    public TreeNode traverse(TreeNode root){
        if(root == null){
           return null;
        }
        if(root.left == null && root.right == null){
           return root;
        }
        TreeNode m = root.left;
        TreeNode n = root.right;
        root.left = null;
        if(m != null){
          root.right = m;
        }
        TreeNode a = traverse(m);
        if(a != null){
           a.right = n;
        }
        TreeNode b = traverse(n);
        return (n == null) ? a:b;
    }
}
