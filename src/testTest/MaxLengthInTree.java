package testTest;

public class MaxLengthInTree {
  private Integer max = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
	  if(root == null) {
		  return 0;
	  }
	  helper(root);
	  return max;
  }
  private int helper(TreeNode root) {
	  if(root == null) {
		  return 0;
	  }
	  int left = helper(root.left);
	  int right = helper(root.right);
	  max = Math.max(max,left + right + root.val);
	  int currentMax = Math.max(left, right) + root.val;
	  return currentMax > 0 ? currentMax:0;
  }
}
