package testTest;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        // write your code here
    	Integer depth = 0;
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.offer(root);
    	while(!q.isEmpty()) {
    		Integer i = 0;
    		Integer b = q.size();
    		for(i = 0;i<b;i++) {
    			TreeNode r = q.poll();
    			if(r.left != null) {
        			q.offer(r.left);
        		}
        		if(r.right != null) {
        			q.offer(r.right);
        		}
    		}
    		depth++;
    	}

    	return depth;
    }
}
