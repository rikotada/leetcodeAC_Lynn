package testTest;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeKthFloorNode939 {
    /**
     * @param root: the root node
     * @param k: an integer
     * @return: the number of nodes in the k-th layer of the binary tree
     */
    public int kthfloorNode(TreeNode root, int k) {
        // Write your code here
        if(root == null){
           return 0;
        }
        int result = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size;i++){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            k--;
            if(k == 0){
               return size;
            }
        }
        return result;
    }
}
