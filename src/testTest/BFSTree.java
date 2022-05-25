package testTest;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTree {
 private static void BreadFirstTree(TreeNode root) {
	 Queue<TreeNode> tree = new LinkedList<>();
	 tree.offer(root);
	 
	  while(!tree.isEmpty()) {
		  TreeNode cur = tree.poll();
		  System.out.println(cur.val);
		  if(cur.left != null) {
			  tree.offer(cur.left);
		  }
		  if(cur.right != null) {
			  tree.offer(cur.right);
		  }
	  }
 }
}
