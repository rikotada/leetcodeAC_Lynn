package testTest;

public class MinimumTree596 {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */

    int min = Integer.MAX_VALUE;
    class Pack{
        public TreeNode result;
        public Pack(TreeNode result){
            this.result = result;
        }
    }
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        if(root == null){
           return root;
        }
        Pack p = new Pack(new TreeNode(0));
        divideAndConquer(root,p);
        return p.result;
    }

    public int divideAndConquer(TreeNode root,Pack p){
          if(root == null){
              return 0;
          }
          int a = divideAndConquer(root.left,p);
          int b = divideAndConquer(root.right,p);
          if((a+b+root.val) < min){
              min = a+b + root.val;
              p.result = root;
          }
          return a+b + root.val;
    }
}
