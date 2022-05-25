package testTest;

import java.util.LinkedHashMap;

public class FirstUniqueCharacterInString209 {
   
    public char firstUniqChar(String str) {
        char result = 'a';
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        int length = str.length();
        for(int i = 0;i < length;i++){
            char ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }
        for(Character ch:map.keySet()){
            if(map.get(ch) == 1){
                result = ch;
                break;
            }
        }
        return result;
    }
}
