package testTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSquares634 {
    /**
     * @param words: a set of words without duplicates
     * @return: all word squares
     */
	List<List<String>> result = new ArrayList<>();
    public List<List<String>> wordSquares(String[] words) {
        // write your code here
	   if(words == null || words.length == 0){
               return result;
	   }
	   Map<String,Set<String>> map = getMap(words);
	   int n = words.length;
	   List<String> currentPath = new ArrayList<>();

	   int length = words[0].length();
	   for(int i = 0;i < n;i++){
		 currentPath.add(words[i]);
           helper(words[i],currentPath,length,1,map);
		 currentPath.clear();

	   }
	   return result;

    }

    public void helper(String start,List<String> currentPath,int n,int index,Map<String,Set<String>> map){
     //    System.out.println(currentPath + " "+index);
	   if(index == n){
		   
		  if(ifMatrix(currentPath)){
		    result.add(new ArrayList<>(currentPath));
		  }            
		  return;
	   }

          String prefix = "";
		for(String ss:currentPath){
              prefix = prefix + ss.substring(index,index + 1); 
		}
		
		Set<String> set = map.get(prefix);
		if(set == null){
			return;
		}
		for(String word:set){

			currentPath.add(word);
			helper(start,currentPath,n,index + 1,map);
			currentPath.remove(currentPath.size() - 1);
		}
	   
	   return;
    }

    public boolean  ifMatrix(List<String> list){
         int n = list.get(0).length();
	    List<String> newList = new ArrayList<>();
	    for(int i = 0;i < n;i++){
            StringBuilder sb = new StringBuilder();
		  for(int m = 0;m < n;m++){
               sb.append(list.get(m).charAt(i));
		  }
		  newList.add(sb.toString());
	    }
	    return newList.equals(list);
    }

    public Map<String,Set<String>> getMap(String[] words){
	     int n = words.length;
          Map<String,Set<String>> map = new HashMap<>();
          int length = words[0].length();
		for(int i = 0;i < n;i++){
             String s = words[i];
		   for(int m = 1; m < length;m++){
                String sub = s.substring(0, m);
			 Set<String> set = null;
                if(!map.keySet().contains(sub)){
                   set = new HashSet<>();
			    set.add(s);
			    map.put(sub,set);
		      }
		      else{
			    set = map.get(sub);
			    set.add(s);
		      }
		   }
		}
          return map;
    }
}