package testTest;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDictionary953 {
    Map<Character,Integer> map = new HashMap<>();
    public boolean isAlienSorted(String[] words, String order) {
          for(int i = 0;i < 26;i++){
             char c = order.charAt(i);
             map.put(c,i);
          }
          int len = words.length;
          for(int i = 0;i < len - 1;i++){
             if(!less(words[i],words[i + 1])){
                 return false;
             }
          }
          return true;
    }

    public boolean less(String w1, String w2){
         int len = Math.min(w1.length(),w2.length());
         for(int i = 0;i < len;i++){
             int a = map.get(w1.charAt(i));
             int b = map.get(w2.charAt(i));
             if(a < b){
                return true;
             }
             else if(a > b){
                return false;
             }
         }
         return w1.length() <= w2.length();
    }
}
