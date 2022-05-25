package testTest;

public class RemoveNodeInBinarySearchTree87 {
    /*
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if(root == null){
           return root;
        }
        
        
        return helper(root,value);

    }

    public TreeNode helper(TreeNode root, int value){
          if(root == null){
             return null;
          }

          if(root.val == value){
            if(root.left == null && root.right == null){
                  return null;
            }
            else if(root.right != null){
                TreeNode pointer1 = root;
                TreeNode pointer2 = root.right;
                while(pointer2.left != null){
                     pointer1 = pointer2;
                     pointer2 = pointer2.left;
                }
                root.val = pointer2.val;
                if(root == pointer1){
                    root.right = pointer2.right;
                }
                else{
                   pointer1.left = pointer2.right;
                }
                
                return root;
            }
            else{
                TreeNode pointer1 = root;
                TreeNode pointer2 = root.left;
                while(pointer2.right != null){
                    pointer1 = pointer2;
                    pointer2 = pointer2.right;
                }
                root.val = pointer2.val;
                if(root == pointer1){
                    root.left = pointer2.left;
                }
                else{
                   pointer1.right = pointer2.left;
                }
                
                return root;

            }
          }

          root.left = helper(root.left,value);
          root.right = helper(root.right,value);

          return root;
    }
}
