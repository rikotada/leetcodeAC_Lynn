package testTest;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges994 {
    int[] varX = {1,-1,0,0};
    int[] varY = {0,0,1,-1};
    int m;
    int n;
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Queue<Integer> q = new ArrayDeque<>();
        int fresh = 0;
        for(int i = 0;i < m;i++){
           for(int j = 0;j < n;j++){
               if(grid[i][j] == 2){
                  q.offer(i * n + j);
               }
               else if(grid[i][j] == 1){
                   fresh++;
               }
           }
        }
        if(q.size() == 0 && fresh > 0){
            return -1;
        }
        if(fresh == 0){
            return 0;
        }
        int step = 0;
        
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i < size;i++){
               int p = q.poll();
               for(int j = 0;j < 4;j++){
                   int newX = p / n + varX[j];
                   int newY = p % n + varY[j];
                   if(!isValid(newX,newY) || 
                      grid[newX][newY] != 1){
                         continue;
                   }
                   grid[newX][newY] = 2;
                   q.offer(newX * n + newY);
               }
            }
            step++;
        }

        for(int i = 0;i < m;i++){
           for(int j = 0;j < n;j++){
               if(grid[i][j] == 1){
                  return -1;
               }
           }
        }
        return step - 1;

    } 

    public boolean isValid(int x,int y){
         if(x < 0 || x >= m || y < 0 || y >= n){
             return false;
         }
         return true;
    }
}