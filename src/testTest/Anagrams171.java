package testTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Anagrams171 {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> result = new LinkedList<String>();
        if(strs == null || strs.length == 0){
            return result;
        }
        int n = strs.length;

        HashMap<String,String> mmap = new HashMap<>();
        for(int i = 0;i < n;i++){
            if(strs[i].equals("")){
                result.add(strs[i]);
                continue;
            }        
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            StringBuilder sb = new StringBuilder();
            int l = strs[i].length();
            for(int k = 0;k < l;k++){
                sb.append(chs[k]);
            }
            String s = sb.toString();
            if(mmap.keySet().contains(s)){
                result.add(strs[i]);
                if(!mmap.get(s).equals("")){
                    result.add(mmap.get(s));
                    mmap.put(s, "");
                }  
            }
            else{
                mmap.put(s,strs[i]);
            }

        }      
        return result;

    }


    

}
