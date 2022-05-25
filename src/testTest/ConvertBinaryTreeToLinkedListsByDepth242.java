package testTest;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConvertBinaryTreeToLinkedListsByDepth242 {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> result = new LinkedList<>();
        if(root == null){
           return result;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
              int size = q.size();
              ListNode headNode = new ListNode(q.peek().val);
              ListNode putInResult = headNode;
              for(int i = 0;i < size;i++){
                  TreeNode node = q.poll();
                  if(node.left != null){
                     q.offer(node.left);
                  }
                  if(node.right != null){
                     q.offer(node.right);
                  }
                  if(i != 0){
                     ListNode lnode = new ListNode(node.val);
                     headNode.next = lnode;
                     headNode = headNode.next;
                  } 
              }
              result.add(putInResult);
        }
        return result;
    }
}
