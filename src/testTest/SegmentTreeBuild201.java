package testTest;

import java.util.ArrayDeque;
import java.util.Queue;

public class SegmentTreeBuild201 {
    /*
     * @param start: start value.
     * @param end: end value.
     * @return: The root of Segment Tree.
     */
	
	
    public SegmentTreeNode build(int start, int end) {
        // write your code here
	   SegmentTreeNode root = new SegmentTreeNode(start,end);
	   if(start == end){
           return root;
	   }
	   if(start > end){
             return null;
	   }
	   
	   Queue<SegmentTreeNode> q = new ArrayDeque<>();
	   q.offer(root);
	   
	   while(!q.isEmpty()){
           SegmentTreeNode node = q.poll();
		 int s = node.start;
		 int e = node.end;
		 SegmentTreeNode left = null;
		 SegmentTreeNode right = null;
		 if(s != e){
               left = new SegmentTreeNode(s,(e - s) / 2 + s);
			node.left = left;
			q.offer(left);
			right = new SegmentTreeNode((e - s) / 2 + s + 1,e);
			node.right = right;
			q.offer(right);
		 }
	   }
	   
	   return root;
    }
}