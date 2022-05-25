package testTest;

import java.util.LinkedList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees1305 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {       
          List<Integer> list1 = new LinkedList<>();
          if(root1 == null && root2 == null){
              return list1;
          }
          List<Integer> list2 = new LinkedList<>();
          if(root1 == null){
              dfs(root2,list2);
              return list2;
          }
          else if(root2 == null){
              dfs(root1,list1);
              return list1;
          }
          else{
              dfs(root1,list1);
              dfs(root2,list2);
          }
          List<Integer> result = new LinkedList<>();
          int index1 = 0;
          int index2 = 0;
          int len1 = list1.size();
          int len2 = list2.size();
          while(index1 < len1 && index2 < len2){
              int a = list1.get(index1);
              int b = list2.get(index2);
              if(a < b){
                  result.add(a);
                  index1++;
              }
              else{
                  result.add(b);
                  index2++;
              }
          }
          
          while(index1 < len1){
              int a = list1.get(index1);
              result.add(a);
              index1++;
          }
          while(index2 < len2){
              int b = list2.get(index2);
              result.add(b);
              index2++;
          }

          return result;

    }

    public void dfs(TreeNode root,List<Integer> list){
         if(root == null){
            return;
         }
         dfs(root.left,list);
         list.add(root.val);
         dfs(root.right,list);
         return;
    }

    
}
