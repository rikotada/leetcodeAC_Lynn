package testTest;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslandsBFS433 {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
     class Pair{
         public int x;
         public int y;
         public Pair(int x,int y){
           this.x = x;
           this.y = y;
        }
     }
    public int numIslands(boolean[][] grid) {
        // write your code here
    	//首先找到一个岛
    	//把所有属于同一个岛的地方都表上已去过
    	//找到下一个岛 看去没去过 没去过就拓展
        if(grid == null || grid.length == 0){
            return 0;
        }
        int depth = grid.length;
        int width = grid[0].length;
        int result = 0;
        int[] xDelta = {0,0,1,-1};
        int[] yDelta = {1,-1,0,0};
        boolean[][] visited = new boolean[depth][width];
        for(int i = 0;i < depth;i++){
           for(int j = 0;j < width;j++){
              if(grid[i][j] && !visited[i][j]){
                 bfs(new Pair(i,j),grid,visited,xDelta,yDelta);
                 result++;
              }
           }
        }
        return result;
    }

    public void bfs(Pair pair,boolean[][] grid,boolean[][] visited,int[] x,int[] y){
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(pair);
        visited[pair.x][pair.y] = true;
        int depth = grid.length;
        int width = grid[0].length;
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i = 0;i < 4;i++){  
               int newX = p.x + x[i];
               int newY = p.y + y[i];
               if(newX < 0 || newX >= depth || newY < 0 || newY >= width){
                  continue;
               }          
               if(!grid[newX][newY] || visited[newX][newY]){
                  continue;
               }
               q.offer(new Pair(newX,newY));
               visited[newX][newY] = true;
            }
        }
    } 
}
