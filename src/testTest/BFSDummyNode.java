package testTest;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class BFSDummyNode {
	public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> list  = new ArrayList<Integer>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node != null){
                list.add(node.val);
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            else{
                result.add(list);
                if(q.size() == 0){
                    break;
                }
                list  = new ArrayList<>();
                q.offer(null);
            }
            
            
        }
        return result;
    }
}
