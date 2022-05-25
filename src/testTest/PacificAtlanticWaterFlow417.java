package testTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class PacificAtlanticWaterFlow417 {
    int[] indexX = {0,1,0,-1};
    int[] indexY = {1,0,-1,0};
    List<List<Integer>> result = new ArrayList<>();
    

    public List<List<Integer>> pacificAtlantic(int[][] heights) {        
         int m = heights.length - 1;
         int n = heights[0].length - 1;
         Set<Integer> connectA = new HashSet<>();
         Set<Integer> connectP = new HashSet<>();
         getPointsConnectToPacific(heights,m,n,connectP);
         getPointsConnectToAtlantic(heights,m,n,connectA);
         if(connectA.size() < connectP.size()){
             addResult(connectA,connectP);
         }
         else{
             addResult(connectP,connectA);
         }
         return result;
    }

    public void addResult(Set<Integer> less,Set<Integer> more){
         for(Integer p : less){
            if(more.contains(p)){
                List<Integer> sub = new ArrayList<>();
                sub.add(p / 1000);
                sub.add(p % 1000);
                result.add(sub);
            }
         }
         return;
    }

    public void getPointsConnectToPacific(int[][] heights,int m,int n,Set<Integer> connectP){
         for(int i = 0;i <= m;i++){
            for(int j = 0;j <= n;j++){
                if(i != 0 && j > 0){
                   break;
                }
                int index = i * 1000 + j;
                if(connectP.contains(index)){
                   continue;
                }
                connectP.add(index);
                dfs(heights,i,j,connectP);
            }
         }
    }

    public void getPointsConnectToAtlantic(int[][] heights,int m,int n,Set<Integer> connectA){
         for(int i = 0;i <= m;i++){
            for(int j = n;j >= 0;j--){
                if(i != m && j < n){
                   break;
                }
                int index = i * 1000 + j;
                if(connectA.contains(index)){
                   continue;
                }
                connectA.add(index);
                dfs(heights,i,j,connectA);
            }
         }
    }


    public void dfs(int[][] heights,int startX,int startY,Set<Integer> visited){
        for(int i = 0;i < 4;i++){
            int newX = startX + indexX[i];
            int newY = startY + indexY[i];
            int newIndex = newX * 1000 + newY;
            if(!isValid(heights,newX,newY) || 
              heights[newX][newY] < heights[startX][startY] ||
              visited.contains(newIndex)){
               continue;
            }
           visited.add(newIndex);
           dfs(heights,newX,newY,visited);
        }
        return;
    }


    public boolean isValid(int[][] heights,int x,int y){
        int m = heights.length - 1;
        int n = heights[0].length - 1;
        if(x < 0 || y < 0 || x > m || y > n){
            return false;
        }

        return true;
    }


}
