package testTest;

import java.util.HashMap;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber270 {
    /**
     * @param queries: the queries
     * @param dict: the words
     * @return: return the queries' answer
     */
    public int[] letterCombinationsII(String[] queries, String[] dict) {
        // write your code here
        if(queries == null || queries.length == 0){
            return new int[0];
        }
        Map<Character,Integer> map =  getMap();
        int numLength = queries.length;
        int dictLength = dict.length;
        int[] result = new int[numLength];
        String[] dictToNum = new String[dictLength];
        for(int i = 0; i < dictLength;i++){
           String s = dict[i];
           StringBuilder sb = new StringBuilder();
           for(int m = 0;m < s.length();m++){
              int reflection = map.get(s.charAt(m));
              sb.append(reflection);
           }
           dictToNum[i] = sb.toString();
        }
        for(int p = 0;p < numLength;p++){
            int num = 0;
            for(int q = 0; q < dictLength;q++){
               String ss = dictToNum[q];
               if(ss.startsWith(""+queries[p])){
                   num++;
               }
            }
            result[p] = num;
        }
        return result;
    }

   
    public Map<Character,Integer> getMap(){
         Map<Character,Integer> map = new HashMap<>();
         map.put('a',2);
         map.put('b',2);
         map.put('c',2);
         map.put('d',3);
         map.put('e',3);
         map.put('f',3);
         map.put('g',4);
         map.put('h',4);
         map.put('i',4);
         map.put('j',5);
         map.put('k',5);
         map.put('l',5);
         map.put('m',6);
         map.put('n',6);
         map.put('o',6);
         map.put('p',7);
         map.put('q',7);
         map.put('r',7);
         map.put('s',7);
         map.put('t',8);
         map.put('u',8);
         map.put('v',8);
         map.put('w',9);
         map.put('x',9);
         map.put('y',9);
         map.put('z',9);
        return map;
    }
}
