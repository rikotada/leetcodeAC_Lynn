package testTest;

import java.util.ArrayDeque;
import java.util.Queue;

public class SegmentTreeQueryII247 {
    /*
     * @param root: The root of segment tree.
     * @param start: start value.
     * @param end: end value.
     * @return: The count number in the interval [start, end]
     */
	class SegmentTreeNode {
	    public int start, end, count;
	    public SegmentTreeNode left, right;
	    public SegmentTreeNode(int start, int end, int count) {
	        this.start = start;
	        this.end = end;
	        this.count = count;
	        this.left = this.right = null;
	    }
	}
	
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(root == null){
            return 0;
        }
        if(root.start == start && root.end == end){
            return root.count;
        }
        int result = 0;
        Queue<SegmentTreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            SegmentTreeNode node = q.poll();
            int s = node.start;
            int e = node.end;
            if(s == start && e == end){
                 return node.count;
            }
            if(start <= s && end >= e){
                result += node.count;
            }
            else if(node.count != 0){
                SegmentTreeNode left = node.left;
                SegmentTreeNode right = node.right;
                if(left != null && left.end >= start){
                     q.offer(left);
                }
                if(right != null && right.start <= end){
                    q.offer(right);
                }

            }
        }
        return result;
    }
}
