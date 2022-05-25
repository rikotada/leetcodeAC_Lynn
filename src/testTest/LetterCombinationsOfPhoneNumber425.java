package testTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber425 {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        // write your code here
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0){
           return result;
        }
        Map<Integer,String[]> map = mobileMap();
        dfs(digits,map,0,"",result);
        return result;
    }

    public Map<Integer,String[]> mobileMap(){
         Map<Integer,String[]> map = new HashMap<>();
         String[] two = {"a","b","c"};
         String[] three = {"d","e","f"};
         String[] four = {"g","h","i"};
         String[] five = {"j","k","l"};
         String[] six = {"m","n","o"};
         String[] seven = {"p","q","r","s"};
         String[] eight = {"t","u","v"};
         String[] nine = {"w","x","y","z"};
         map.put(2,two);
         map.put(3,three);
         map.put(4,four);
         map.put(5,five);
         map.put(6,six);
         map.put(7,seven);
         map.put(8,eight);
         map.put(9,nine);
         return map;
    }

    public void dfs(String digits,Map<Integer,String[]> map,int index,String current,List<String> result){
        if(index == digits.length()){
            result.add(current);
            return;
        }
        String[] alphabets = map.get(Integer.parseInt(digits.substring(index,index+1)));
        int size = alphabets.length;
        for(int i = 0; i < size;i++){
             String current2 = current + alphabets[i];
             dfs(digits,map,index+1,current2,result);
        }
        return;
    }
    

}
