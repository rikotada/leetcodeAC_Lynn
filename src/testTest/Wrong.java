package testTest;

import java.util.ArrayList;
import java.util.List;

public class Wrong {
    public int sum = 0;
    public List<Integer> a= new ArrayList<>(); 
    public List<List<Integer>> b = new ArrayList<>();
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
       a= new ArrayList<>();
       b = new ArrayList<>();
       traverseTree(root,target,a,b);
     return b;
    }
    
    public void traverseTree(TreeNode root, int target, List<Integer> a, List<List<Integer>> b) {
        if(root == null) {
           return;
        }     
        a.add(root.val); 
        target = target - root.val;  
        if(root.left == null && root.right == null && target == 0) {
           b.add(a);
           a.remove(a.lastIndexOf(root.val));  
           target = target + root.val;
           return;
        }
        else if(root.left == null && root.right == null && target != 0) {
           a.remove(a.lastIndexOf(root.val));
           target = target + root.val;
           return;
        }     
       traverseTree(root.left,target,a,b);     
       traverseTree(root.right,target,a,b);
       a.remove(a.lastIndexOf(root.val));    
       target = target + root.val;
    }
}
