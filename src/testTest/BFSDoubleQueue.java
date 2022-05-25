package testTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class BFSDoubleQueue {

	 int[][] M = new int[2][2];
	 int a = M.length;
	
	  public List<List<Integer>> levelOrder(TreeNode root) {
		  Set<Integer> a = new HashSet<>();
		 
	  List<List<Integer>> result = new ArrayList<>();
	        if(root == null){
	            return result;
	        }
	        List<TreeNode> queue = new ArrayList<TreeNode>();
	        queue.add(root);
	        while(!queue.isEmpty()){
	            List<TreeNode> queue2 = new ArrayList<TreeNode>();
	            result.add(helper(queue));
	           
	            for(TreeNode node:queue){
	                if(node.left != null){
	                    queue2.add(node.left);
	                }
	                if(node.right != null){
	                    queue2.add(node.right);
	                }
	            }
	            queue = queue2;
	        }
	        return result;
	    }
	    
	    private List<Integer> helper(List<TreeNode> q){
	        List<Integer> result = new ArrayList<>();
	        if(q.isEmpty()){
	            return result;
	        }
	       for(TreeNode node:q){
	           result.add(node.val);
	       }
	        return result;
	    }
}
