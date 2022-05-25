package testTest;

public class TwoSumIVInputBST689 {
    /*
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */
    public int[] twoSum(TreeNode root, int n) {
        // write your code here
        if(root == null){
            return null;
        }
        int[] list = new int[2];
        helper(root,n,list);
        if(list[0] == 0 && list[1] == 0){
            return null;
        }
        return list;
    }
    
    public void helper(TreeNode root,int n, int[] list){
        if(root == null){
            return;
        }

        if(root.val != (n - root.val) &&findNode(root,n-root.val) != null){
            list[0] = root.val;
            list[1] = n - root.val;
            return;
        }
        else{
            helper(root.left,n,list);
            helper(root.right,n,list);
        }
        return;
    }
    
    public TreeNode findNode(TreeNode root, int n){
        if(root == null){
            return null;
        }
        if(root.val < n){
            return findNode(root.right,n);
        }
        else if(root.val > n){
             return findNode(root.left,n);
        }
        else if(root.val == n){
            return root; 
        }
        return null;
    }
}
