package testTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BinaryTreePathSumIII472 {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        // write your code here
        if(root  == null){
           
            return result;
        }
        traverseTree(root, target);
        return result;
    }
    
    //包含与不包含的选项在这个遍历里面选 把每个点放在【一定包含】的立场
    public void traverseTree(ParentTreeNode root,int target){
           if(root == null){
              return;
           }
           helper(root,new LinkedList<>(),target,0);

           traverseTree(root.left,target);
           traverseTree(root.right,target);
           return;

    }
 

    //以root为起点往各个方向走 一定包含路上的每个点
    public void helper(ParentTreeNode root, List<ParentTreeNode> currentPath,int target,int current){
        if(root == null){
            return;
        }
        current += root.val;
        currentPath.add(root);
        if(current == target){
           List<Integer> list = new ArrayList<>();
           for(ParentTreeNode node:currentPath){
              list.add(node.val);
           }
           result.add(list);
        }
        Set<ParentTreeNode> set = new HashSet<>(currentPath);
        if(!set.contains(root.left)){
           helper(root.left,currentPath,target,current);
        }
        if(!set.contains(root.right)){
           helper(root.right,currentPath,target,current);
        }
        if(!set.contains(root.parent)){
           helper(root.parent,currentPath,target,current);
        }
        currentPath.remove(currentPath.size() - 1);
        
        return;
    }
}
