package testTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class WordSorting819 {
    /**
     * @param alphabet: the new alphabet
     * @param words: the original string array
     * @return: the string array after sorting
     */
    public String[] wordSort(char[] alphabet, String[] words) {
        // Write your code here
        if(words == null || words.length == 0){
            return words;
        }
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < 26;i++){
           map.put(alphabet[i],i+1);
        }

        Arrays.sort(words, new Comparator<String>(){
            public int compare(String s1,String s2){
                if(s1.equals(s2)){
                   return 0;
                }
                int a = s1.length();
                int b = s2.length();
                for(int i = 0;i < Math.min(a,b);i++){
                    if(map.get(s1.charAt(i)) < map.get(s2.charAt(i))){
                          return -1;
                    }
                    else if(map.get(s1.charAt(i)) > map.get(s2.charAt(i))){
                          return 1;
                    }
                }
                if(a < b){
                   return -1;
                }
                return 1;
            }
        });

        return words;
    }
}
