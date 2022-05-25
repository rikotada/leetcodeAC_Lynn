package testTest;


public class InorderPredecessorInBST915 {
    /**
     * @param root: the given BST
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    TreeNode result = null;
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        // write your code here

        if(root == null){
             return null;
        }
        dfs(root, p);
        return result;
        
    }

    public void dfs(TreeNode node, TreeNode p){
        if(node == null){
           return;
        }
        dfs(node.left,p);
        if(node.val < p.val){
           result = node;
        }
        dfs(node.right,p);
        return;  
    }

    
}