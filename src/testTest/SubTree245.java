package testTest;

public class SubTree245 {
   public boolean isSubtree(TreeNode tree, TreeNode subtree) {
	   if(subtree == null) {
		   return true;
	   }
	   if(tree == null && subtree != null) {
		   return false;
	   }
	   if(treeEqual(tree,subtree)) {
		   return true;
	   }
	   return isSubtree(tree.left,subtree) || isSubtree(tree.right,subtree);
   }
   
   private boolean treeEqual(TreeNode tree, TreeNode subtree) {
	   if(tree == null && subtree == null) {
		   return true;
	   }
	   if(tree == null || subtree == null) {
		   return false;
	   }
	   if(tree.val != subtree.val) {
		   return false;
	   }
	   return treeEqual(tree.left,subtree.left) && treeEqual(tree.right,subtree.right);
   }
}
