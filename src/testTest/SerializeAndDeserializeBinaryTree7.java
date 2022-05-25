package testTest;

import java.util.ArrayDeque;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree7 {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if(root == null){
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            sb.append(n.val);
            sb.append("+");
            if(n.left != null){
                sb.append(n.left.val);
                q.offer(n.left);
            }
            else{
                sb.append("#");
            }
            sb.append("+");
            if(n.right != null){                  
                sb.append(n.right.val);
                q.offer(n.right);
            }
            else{
                sb.append("#");
            }
            sb.append(".");
                               
        }
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if(data.equals("#")){
            return null;
        }
        String[] nodes = data.split("\\.");
        int n = nodes.length;
        String nodeInfo = nodes[0];
        String[] vals = nodeInfo.split("\\+");
        String val1 = vals[0];
        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(val1));
        q.offer(root);
        int i = 0;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            nodeInfo = nodes[i];
            vals = nodeInfo.split("\\+");
            if(!vals[1].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(vals[1]));
                node.left = left;
                q.offer(left);
            }
            if(!vals[2].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(vals[2]));
                node.right = right;
                q.offer(right);
            }
            i++;
        }
        return root;

    }

}
