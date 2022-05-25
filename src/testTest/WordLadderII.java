package testTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    int shortest = Integer.MAX_VALUE;
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if(dict == null || dict.size() == 0){
            result.add(new ArrayList<>());
            return result;
        }
        dict.add(end);
        dict.add(start);
        Map<String,Set<String>> map = map(dict);
        Map<String,Integer> path = new HashMap<>();
        shortest = bfs(start, end, dict,map,path);
        System.out.println(shortest);
 
        Set<String> used = new HashSet<>();
        used.add(start);
        List<String> current = new ArrayList<>();
        current.add(start);
        
        dfs(start,end,map,dict,used,current,result,path);
        return result;
 
    }
 
    public void dfs(String start,String end,Map<String,Set<String>> map,
                    Set<String> dict,Set<String> used,List<String> current,
                    List<List<String>> result,Map<String,Integer> path){
        if(current.size() > shortest || path.get(start) == null || current.size() >path.get(start) ){
             return;
        }
        if(start.equals(end)){
            result.add(new ArrayList<>(current));
            return;
        }
        Set<String> nextStep = map.get(start);
        if(nextStep == null || nextStep.size() == 0){
            return;
        }
        for(String next:nextStep){
            if(used.contains(next)){
               continue;
            }
            used.add(next);
            current.add(next);
            dfs(next,end,map,dict,used,current,result,path);
            used.remove(next);
            current.remove(current.size() - 1);
        }
        return;
 
    }
 
    public Set<String> changeOne(String word,Set<String> dict){
         Set<String> result = new HashSet<>();
         int n = word.length();
         for(String str:dict){
             int diff = 0;
             for(int i = 0;i < n;i++){
                if(word.charAt(i) != str.charAt(i)){
                    diff++;
                }
                if(diff > 1){
                    break;
                }
             }
             if(diff == 1){
                  result.add(str);
             }
         }
         return result;
    }
 
    public Map<String,Set<String>> map(Set<String> dict){
        Map<String,Set<String>> result = new HashMap<>();
        for(String word:dict){
            Set<String> set = changeOne(word,dict);
            result.put(word,set);
        }
        return result;
    }
 
    public int bfs(String start,String end,Set<String> dict,
                   Map<String,Set<String>> map,Map<String,Integer> path){
          int step = 1;
          Queue<String> q = new ArrayDeque<>();
          q.offer(start);
          Set<String> used = new HashSet<>();
          used.add(start);
          while(!q.isEmpty()){
              int size = q.size();
              for(int i = 0;i < size;i++){
                  String str = q.poll();
                  path.put(str, step);
                  if(str.equals(end)){
                      return step;
                  }
                  Set<String> set = map.get(str);
                //   System.out.println("word: "+str);
                  if(set == null){
                      continue;
                  }
                  
                  for(String w:set){
                     if(used.contains(w)){
                        continue;
                     }
                     q.offer(w);
                     used.add(w);
                  }
              }
              step++;
 
          }
          return step;
    }
 
}
