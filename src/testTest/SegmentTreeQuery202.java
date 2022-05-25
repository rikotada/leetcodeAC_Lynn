package testTest;

import java.util.ArrayDeque;
import java.util.Queue;

public class SegmentTreeQuery202 {
    /**
     * @param root: The root of segment tree.
     * @param start: start value.
     * @param end: end value.
     * @return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(root.start == start && root.end == end){
            return root.max;
        }
        int result = Integer.MIN_VALUE;
        Queue<SegmentTreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
             SegmentTreeNode node = q.poll();
             SegmentTreeNode left = null;
             SegmentTreeNode right = null;;
             if(node.start >= start && node.end <= end){
                 result = Math.max(node.max,result);
             }
             else{
                 left = node.left;
                 right = node.right;
                 if(left.end >= start){
                     q.offer(left);
                 }
                 if(right.start <= end){
                     q.offer(right);
                 }
             }
             
        }
        return result;
    }
}
