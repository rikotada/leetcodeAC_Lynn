package testTest;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class KnightShortestPath611 {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */

    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        if(grid == null || grid.length == 0){
           return -1;
        }
        if(source.x == destination.x && source.y == destination.y){
           return 0;
        }
        int depth = grid.length;
        int width = grid[0].length;
        int path = 0;
        boolean[][] visited = new boolean[depth][width];
        int[] x = {1,1,-1,-1,2,2,-2,-2};
        int[] y = {2,-2,2,-2,1,-1,1,-1};
        Queue<Point> q = new ArrayDeque<>();
        q.offer(source);
        visited[source.x][source.y] = true;
        int n = 1;
        Point p = q.peek();
        while(!q.isEmpty()){        
            for(int m = 0;m < n;m++){
                p = q.poll();
                for(int i = 0; i<8;i++){
                int newX = p.x + x[i];
                int newY = p.y + y[i];
                if(newX < 0 || newX >= depth || newY < 0|| newY >= width){
                    continue;
                }
                if(visited[newX][newY] || grid[newX][newY]){
                    continue;
                }
                if(destination.x == newX && destination.y == newY){
                    return path + 1;
                }
                q.offer(new Point(newX,newY));
                visited[newX][newY] = true;
                }
            }
            n = q.size();
            path++;
        }
        return -1;
    }
}
