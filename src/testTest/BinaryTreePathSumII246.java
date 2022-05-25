package testTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BinaryTreePathSumII246 {

    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
           return result;
        }
        Map<TreeNode,Set<TreeNode>> map = new HashMap<>();
        Map<TreeNode,Set<TreeNode>> called = new HashMap<>();
        dfs(root,root,target,root,new ArrayList<>(),0,result,map,called);
        return result;
    }
    
    public void dfs(TreeNode root,TreeNode node, int target, TreeNode start,List<Integer> current,int currentSum, 
                    List<List<Integer>> result,Map<TreeNode,Set<TreeNode>> map,Map<TreeNode,Set<TreeNode>> called){
        if(node == null){
           return;
        }
        
        if(currentSum + node.val == target){
            current.add(node.val);
            if(check(map,start,node)){
               result.add(new ArrayList<>(current));
            }
            current.remove(current.size() -1);
        }
        
        current.add(node.val);
        if(node.left != null){
            if(check(called,start,node.left)){
                dfs(root,node.left,target,start,current,currentSum + node.val,result,map,called);
            }
            if(check(called,node.left,node.left)){
               dfs(root,node.left,target,node.left,new ArrayList<>(),0,result,map,called);
            }
        }
        if(node.right != null){   
            if(check(called,start,node.right)){
                dfs(root,node.right,target,start,current,currentSum + node.val,result,map,called);
            }
            if(check(called,node.right,node.right)){
               dfs(root,node.right,target,node.right,new ArrayList<>(),0,result,map,called);
            }       
        }
        current.remove(current.size() -1);
        return;
    }

    public boolean check(Map<TreeNode,Set<TreeNode>> called,TreeNode start,TreeNode to){
        if(called.keySet().contains(start) && called.get(start).contains(to)){
            return false;
        }
        if(!called.keySet().contains(start)){
            Set<TreeNode> set = new HashSet<>();
            set.add(to);
            called.put(start,set);
        }
        else if(!called.get(start).contains(to)){
            Set<TreeNode> set = called.get(start);
            set.add(to);
            called.put(start,set);
        }
        return true;

    }
   
}
