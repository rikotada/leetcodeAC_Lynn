package testTest;

public class CutBST701 {
    public TreeNode trimBST(TreeNode root, int min, int max) {
    	if(root == null) {
    		return root;
    	}
    	//if both left & right satisfies condition
    	if(root.val <= max && root.val >= min) {
    		root.left = trimBST(root.left,min,max);
    		root.right = trimBST(root.right,min,max);
    	}
    	//if root is less than minimal value
    	//remove the root and left tree
    	//remove means return nothing
    	if(root.val < min) {
    		return trimBST(root.right,min,max);
    	}
    	//else remove root and right tree
        return trimBST(root.left,min,max);

    }
}
