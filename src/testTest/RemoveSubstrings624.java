package testTest;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class RemoveSubstrings624 {
    /**
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        // write your code here
        if(s == null || s.length() == 0){
            return 0;
        }
        int result = s.length();
        Queue<String> q = new ArrayDeque<>();
        q.offer(s);
        Set<String> added = new HashSet<>();
        added.add(s);
        while(!q.isEmpty()){    
            String str = q.poll();
            if(str.length() < result){
                    result = str.length();
            }
            for(String word:dict){
                int index = str.contains(word) ? 0 : -1;
                int lastStartIndex = 0;
                while(index >= 0){
                    index = str.indexOf(word, lastStartIndex);
                    if(index < 0){
                       break;
                    }
                    String before = str.substring(0, index);
                    String after = str.substring(index + word.length(), str.length());
                    String r = before + after;
                    lastStartIndex = index + word.length();
                    if(r.length() == 0){
                        return 0;
                    }
                    if(!added.contains(r)){
                        q.offer(r);
                    }
                    added.add(r);
                }
            }   
        }
        return result;
    }
}
