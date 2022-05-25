package testTest;

import java.util.ArrayDeque;
import java.util.Queue;

public class TheMazeII788 {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: the shortest distance for the ball to stop at the destination
     */
    class Point{
        int x;
        int y;
        public Point(int x,int y){
           this.x = x;
           this.y = y;
        }
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // write your code here
        if(maze == null || maze.length == 0){
            return -1;
        }
        if(maze[start[0]][start[1]] == 1 || maze[destination[0]][destination[1]] == 1){
           return -1;
        }
        if(start.equals(destination)){
           return 0;
        }
      
        int[] xDelta = {1,0,0,-1};
        int[] yDelta = {0,1,-1,0};
        int rows = maze.length;
        int cols = maze[0].length;
        int[][] minSteps = new int[rows][cols];
        for(int i = 0; i < rows;i++){
            for(int j = 0; j < cols;j++){
                minSteps[i][j] = Integer.MAX_VALUE;
            }
        }
        minSteps[start[0]][start[1]] = 0;
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(start[0],start[1]));
        label1:
        while(!q.isEmpty()){
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int index = 0;index < 4;index++){
                int subX = x;
                int subY = y;
                int move = 0;
                while(isValid(maze,subX + xDelta[index],subY + yDelta[index])){
                     subX = subX + xDelta[index];
                     subY = subY + yDelta[index];
                     move++;
                }
                if(minSteps[subX][subY] > minSteps[x][y] + move){
                    minSteps[subX][subY] = minSteps[x][y] + move;
                    q.offer(new Point(subX,subY));
                }
                
            }

        }
        int result = minSteps[destination[0]][destination[1]];
        if(result > 100000){
            result = -1;
        }
        return result;

    }

   

    public boolean isValid(int[][] maze, int x, int y){
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