package testTest;

import java.util.ArrayList;
import java.util.List;

public class SearchRangeInBinarySearchTree11 {
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }
        helper(root,k1,k2,list);
        return list;
    }
    
    public void helper(TreeNode root, int k1, int k2,List<Integer> list){
        if(root == null){
            return;
        }
        
        helper(root.left,k1,k2,list);
        if(root.val <= k2 && root.val >= k1){
            list.add(root.val);
        }
        helper(root.right,k1,k2,list);
        return;
    }
}
