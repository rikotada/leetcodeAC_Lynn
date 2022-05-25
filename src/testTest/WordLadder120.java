package testTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder120 {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if(start.length() != end.length()){
            return 0;
        }
        dict.add(end);
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.offer(start);
        visited.add(start);
        int path = 1;
        String s = q.peek();
        while(!q.isEmpty()){
            int size = q.size();
            //分层的要点：在最开始get整个队列的size 然后处理都放在大循环里           
            for(int i = 0;i<size;i++){
                s = q.poll();
                List<String> list = findConvertableWord(s,dict);
                for(String dictWord:list){
                   if(visited.contains(dictWord)){
                      continue;
                    }
                    else{
                       q.offer(dictWord);
                       visited.add(dictWord);
                    }
                    if(dictWord.equals(end)){
                       return path+1;
                    }
                }
            }
            path++;          
        }
        return 0;
    }
    public List<String> findConvertableWord(String word,Set<String> dict){
        List<String> result = new ArrayList<>();
        for(String dictWord:dict){
            if(isConvertable(word,dictWord)){
                result.add(dictWord);
            }
        }
        return result;
    }

    public boolean isConvertable(String word,String dictWord){
        int n = word.length();
        int m = dictWord.length();
        if(n != m){
            return false;
        }
        boolean firstDiff = false;
        for(int k = 0;k < n; k++){
           if(!firstDiff && (word.charAt(k) != dictWord.charAt(k))){
               firstDiff = true;
           }
           else if(firstDiff && (word.charAt(k) != dictWord.charAt(k))){
               return false;
           }
        }
        return firstDiff;
    }
}
