package testTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringPermutationII10 {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> result = new ArrayList<>();
        if(str == null || str.length() == 0){
           result.add("");
           return result;
        }
        Map<String,Integer> map = new HashMap<>();
        int length = str.length();
        for(int i = 0;i < length;i++){
           String single = str.substring(i,i+1);
           map.put(single,map.getOrDefault(single,0)+1);
        }
        dfs(str,map,0,"",result);
        return result;
    }

    public void dfs(String str,Map<String,Integer> map,int index,String current,List<String> result){
          if(index == str.length()){
            result.add(current);
            return;
          }
          for(String s:map.keySet()){
              if(map.get(s) == 0){
                 continue;
              }
              String current2 = current + s;
              map.put(s, map.get(s) - 1);
              dfs(str,map,index+1,current2,result);
              map.put(s, map.get(s) + 1);
          }
          return;
    }
}
