package testTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class CountOfSmallerNumber248 {
    /**
     * @param A: An integer array
     * @param queries: The query list
     * @return: The number of element in the array that are smaller that the given integer
     */
    class SegmentTreeNode{
        int start;
        int end;
        int max;
        int min;
        SegmentTreeNode left = null;
        SegmentTreeNode right = null;
        public SegmentTreeNode(int start,int end,int max,int min){
            this.start = start;
            this.end = end;
            this.max = max;
            this.min = min;
        }
    }
    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if(A == null || A.length == 0){
             for(int k = 0;k < queries.length;k++){
                 result.add(0);
             }
             return result;
        }
        Arrays.sort(A);
        SegmentTreeNode root = buildTree(A);
        int l = queries.length;
        Queue<SegmentTreeNode> q = new ArrayDeque<>();
        for(int i = 0;i < l;i++){
            if(queries[i] > A[A.length - 1]){
                result.add(A.length);
            }
            else if(queries[i] <= A[0]){
                result.add(0);
            }
            else{
                result.add(findCount(root, queries[i],q));
            }
        }
        return result;

    }

    public int findCount(SegmentTreeNode root,int val,Queue<SegmentTreeNode> q){
          int result = 0;
          q.add(root);
          while(!q.isEmpty()){
              SegmentTreeNode node = q.poll();
              if(val > node.min){
                  if(val > node.max){
                     result += node.end - node.start + 1;
                  }
                  else if(node.start == node.end){
                      result++;
                  }
                  else{
                      q.offer(node.left);
                      int m = node.right.min;
                      if(val > m){
                         q.offer(node.right);
                      }
                  }
              }
          }
          return result;
    }

    public SegmentTreeNode buildTree(int[] A){
    	
         
         int len = A.length;
         SegmentTreeNode root = new SegmentTreeNode(0,len - 1,A[len - 1],A[0]);
         Queue<SegmentTreeNode> q = new ArrayDeque<>();
         q.offer(root);
         while(!q.isEmpty()){
            SegmentTreeNode node = q.poll();
            if(node.start != node.end){
               int s = node.start;
               int e = node.end;
               int m = (e - s) / 2 + s;
               SegmentTreeNode left = new SegmentTreeNode(s,m,A[m],A[s]);
               SegmentTreeNode right= new SegmentTreeNode(m + 1,e,A[e],A[m + 1]);
               node.left = left;
               node.right = right;
               q.offer(left);
               q.offer(right);
            }
         }
        return root;
    }
}
