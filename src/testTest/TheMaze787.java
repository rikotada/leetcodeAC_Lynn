package testTest;

import java.util.ArrayDeque;
import java.util.Queue;

public class TheMaze787 {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    class Point{
        int x;
        int y;
        int step;
        public Point(int x, int y){
           this.x = x;
           this.y = y;
        }
    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        int[] xDelta = {1,0,0,-1};
        int[] yDelta = {0,1,-1,0};
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(start[0],start[1]));
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()){
              Point p = q.poll();
              int x = p.x;
              int y = p.y;
              for(int i = 0; i < 4;i++){
                 int subX = x;
                 int subY = y;
                 while(isValid(maze,subX + xDelta[i],subY + yDelta[i])){
                     subX += xDelta[i];
                     subY += yDelta[i];
                 }
                 if(subX == destination[0] && subY == destination[1]){
                    return true;
                 }
                 if(maze[subX][subY] == 0){
                    q.offer(new Point(subX,subY));
                 }
                 maze[subX][subY] = 2;
                 
              }
        }
        return false;
    }

    public boolean isValid(int[][] maze,int x,int y){
       int rows = maze.length;
       int cols = maze[0].length;
       if(x < 0 || x >= rows || y < 0 || y >= cols){
          return false;
       }
       if(maze[x][y] == 1){
          return false;
       }
       return true;
    }
}
