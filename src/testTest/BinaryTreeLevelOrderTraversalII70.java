package testTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversalII70 {
    /**
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        Stack<List<Integer>> stack = new Stack<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> subList = new ArrayList<>();
            for(int i = 0; i< size;i++){               
                TreeNode node = q.poll();
                subList.add(node.val);
                 if(node.left != null){
                    q.offer(node.left);
                 }
                 if(node.right != null){
                    q.offer(node.right);
                 }
            }
            stack.push(subList);
        }
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }
}