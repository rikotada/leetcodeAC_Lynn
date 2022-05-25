package testTest;

import java.util.HashMap;
import java.util.Map;

public class CanIWin464 {
    Map<Integer,Boolean> map = new HashMap<>();
    int max;
    int total;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
         if(desiredTotal <= maxChoosableInteger){
               return true;
         }
         if(((1 + maxChoosableInteger) * maxChoosableInteger / 2) < desiredTotal){
             return false;
         }
         max = maxChoosableInteger;
         total = desiredTotal;
         return dfs(0,0);
    }

    public boolean dfs(int used,int sum){
        if(map.containsKey(used)){
            return map.get(used);
        }
        boolean result = false;
        for(int i = 1;i <= max;i++){
            if(((used >> (i - 1)) & 1) == 1){
                continue;
            }
            
            if(sum + i >= total || !dfs(used | 1 << (i - 1),sum + i)){
                result = true;
                break;
            } 
        }
         map.put(used,result);
         return map.get(used);
    }
}
