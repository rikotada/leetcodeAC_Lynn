package testTest;

import java.util.ArrayList;
import java.util.List;


public class LeafNode {
	 public int sum = 0;
	 public List <Integer> a = new ArrayList <> ();
	 public List <List <Integer>> b = new ArrayList <> ();
	 public List <List<Integer>> binaryTreePathSum(TreeNode root, int target) {
	        a = new ArrayList <> ();
	        b = new ArrayList <> ();
	        traverseTree(root, target);
	        return b;
	 }
	 public void traverseTree(TreeNode root, int target) {
	        if(root == null) {
	            return;
	        }
	        a.add(root.val);
	        target = target - root.val;
	        if(root.left == null && root.right == null && target == 0) {
	            // b.add(a);
	            b.add(new ArrayList<>(a));
	            a.remove(a.lastIndexOf(root.val));
	            target = target + root.val;
	            System.out.println("Root value: "+ root.val+" a: "+a+" b: "+b);
	            return;
	        }
	        else if(root.left == null && root.right == null && target != 0) {
	            a.remove(a.lastIndexOf(root.val));
	            target = target + root.val;
	            System.out.println("Root value: "+ root.val+" a: "+a+" b: "+b);
	            return;
	        }
	        traverseTree(root.left, target);
	        traverseTree(root.right, target);
	        a.remove(a.lastIndexOf(root.val));
	        target = target + root.val;
	    }
	 
	 
	 public static void main(String[] args) {
			LeafNode lf = new LeafNode();
			TreeNode a = new TreeNode(1);
			TreeNode b = new TreeNode(2);
			TreeNode c = new TreeNode(2);
			TreeNode d = new TreeNode(3);
			TreeNode e = new TreeNode(4);
			a.left = b;
			a.right = e;
			b.left = c;
			b.right = d;
			lf.binaryTreePathSum(a, 5);
					
	  }
}
