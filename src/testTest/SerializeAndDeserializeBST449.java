package testTest;

import java.util.ArrayDeque;
import java.util.Queue;

public class SerializeAndDeserializeBST449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.val == -1){
                sb.append("#");
            }
            else{
                sb.append(node.val);
                if(node.left != null){
                    q.offer(node.left);
                }
                else{
                    q.offer(new TreeNode(-1));
                }
                if(node.right != null){
                    q.offer(node.right); 
                }
                else{
                    q.offer(new TreeNode(-1));
                }
                
                
            }
            sb.append("_");
                
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        String[] arr = data.split("_");
        int len = arr.length;
        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        int index = 1;
        while(index < len){
            TreeNode node = q.poll();
            if(arr[index].equals("#")){
                 node.left = null;
            }
            else{
                TreeNode leftNode = new TreeNode(Integer.parseInt(arr[index]));
                node.left = leftNode;
                q.offer(leftNode);
            }
            index++;
            if(index >= len){
                break;
            }
            if(arr[index].equals("#")){
                 node.right = null;
            }
            else{
                TreeNode rightNode = new TreeNode(Integer.parseInt(arr[index]));
                node.right = rightNode;
                q.offer(rightNode);
            }
            index++;
            if(index >= len){
                break;
            }
        }
        
        return root;
    }
}
