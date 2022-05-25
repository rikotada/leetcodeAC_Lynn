package testTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TravelingSalesmanProblem816 {
    /**
     * @param n: an integer,denote the number of cities
     * @param roads: a list of three-tuples,denote the road between cities
     * @return: return the minimum cost to travel all cities
     */
    int minCost = Integer.MAX_VALUE;
    public int minCost(int n, int[][] roads) {
        // Write your code here
        Map<String,Integer> map = new HashMap<>();
        int roadNum = roads.length;
        for(int i = 0;i < roadNum;i++){
            String key1 = roads[i][0]+""+roads[i][1];
            String key2 = roads[i][1]+""+roads[i][0];
            if(map.get(key1) != null && roads[i][2] > map.get(key1)){
               continue;
            }
            map.put(key1,roads[i][2]);
            map.put(key2,roads[i][2]);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        dfs(map,1,visited,0,n);
        return minCost;
    }

    public void dfs(Map<String,Integer> map,int previous,Set<Integer> visited,int currentCost,int n){
         if(currentCost > minCost){
            return;
         }
         if(visited.size() == n){
             minCost = Math.min(currentCost,minCost);
             return;
         }
         for(int i = 2;i <= n;i++){
            if(visited.contains(i)){
                continue;
            }
            int cost = map.getOrDefault(previous+""+i, 1000000);
            if(cost == 1000000 || previous == i){
               continue;
            }
            visited.add(i);
            dfs(map,i,visited,currentCost + cost,n);
            visited.remove(i);
         }
         return;
    }
}
