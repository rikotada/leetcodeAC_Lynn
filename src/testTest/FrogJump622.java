package testTest;

import java.util.HashSet;
import java.util.Set;

public class FrogJump622 {
    /**
     * @param stones: a list of stones' positions in sorted ascending order
     * @return: true if the frog is able to cross the river or false
     */
    boolean result = false;
    public boolean canCross(int[] stones) {
        // write your code here
        if(stones.length == 1){
           return true;
        }

        Set<Integer> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for(int i = 0;i < stones.length;i++){
           set.add(stones[i]);
        }
        int max = stones[stones.length - 1];
        dfs(stones,0,1,max,set,visited);
        return result;

    }

    public void dfs(int[] stones,int currentLocation,int nextStep,int max,Set<Integer> set,Set<String> visited){
        // System.out.println("currentLoction: "+currentLocation+ " nextStep: "+nextStep);
        if(result || currentLocation > max){
           return;
        }
        if(currentLocation == max){
           result = true;
        }
        
        if(nextStep - 1 > 0 && set.contains(nextStep - 1 + currentLocation)){
            int a = nextStep - 1 + currentLocation;
            int b = nextStep - 1;
            if(!visited.contains(a+"_"+b)){
                visited.add(a+"_"+b);
                dfs(stones,nextStep - 1 + currentLocation,nextStep - 1,max,set,visited);
            }
            
        }
        if(set.contains(nextStep + currentLocation)){
            int a = nextStep + currentLocation;
            int b = nextStep;
            if(!visited.contains(a+"_"+b)){
                visited.add(a+"_"+b);
                dfs(stones,nextStep + currentLocation,nextStep,max,set,visited);
            }
        }
        if(set.contains(nextStep + 1 +currentLocation)){
            int a = nextStep + 1 + currentLocation;
            int b = nextStep + 1;
            if(!visited.contains(a+"_"+b)){
                visited.add(a+"_"+b);
                dfs(stones,nextStep + 1 + currentLocation,nextStep + 1,max,set,visited);
            }
        }
        return;

    }
}
