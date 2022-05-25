package testTest;

public class KthSmallestElementInBST902 {
    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    int count = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        if(root == null){
            return -1;
        }
        traverse(root,k);
        return result;
    }

    public void traverse(TreeNode root,int k){
         if(root == null){
            return;
         }
         traverse(root.left,k);
         count++;
         if(count == k){
           result = root.val;
         }
         traverse(root.right,k);
    }
}
