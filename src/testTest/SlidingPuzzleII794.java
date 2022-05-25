package testTest;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzleII794 {
    /**
     * @param init_state: the initial state of chessboard
     * @param final_state: the final state of chessboard
     * @return: return an integer, denote the number of minimum moving
     */
    public int minMoveStep(int[][] init_state, int[][] final_state) {
        // # write your code here
        if(init_state.equals(final_state)){
            return 0;
        }
        int[] xDelta = {1,0,0,-1};
        int[] yDelta = {0,1,-1,0};
        Queue<int[][]> q = new ArrayDeque<>();
        q.offer(init_state);
        Set<Integer> visited = new HashSet<>();
        visited.add(hashing(init_state));
        int fin = hashing(final_state);
        int result = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int index = 0;index < size;index++){
                int[][] nowState = q.poll();
                int zeroHere = zeroPosition(nowState);
                int x = zeroHere / 3;
                int y = zeroHere % 3;
                for(int i = 0;i < 4;i++){
                    int subX = x + xDelta[i];
                    int subY = y + yDelta[i];
                    if(!isValid(subX,subY)){
                        continue;
                    }
                    int[][] newState = copy2DArray(nowState);
                    newState[x][y] = newState[subX][subY];
                    newState[subX][subY] = 0;
                    int newHash  = hashing(newState);
                    if(newHash == fin){
                            return result;
                    }
                    if(visited.contains(hashing(newState))){
                        continue;
                    }
                    q.offer(newState);
                    visited.add(hashing(newState));
                }
            }
            
            result++;

        }
        return -1;
    }

    public int hashing(int[][] state){
       int result = 0;
       for(int i = 0;i < 3;i++){
          for(int j = 0; j < 3;j++){
              int a = i * 3  + j;
              result = result + state[i][j] * (int)Math.pow(10,a);
          }
       }
       return result;
    }

    public int zeroPosition(int[][] state){
       for(int i = 0;i < 3;i++){
          for(int j = 0; j < 3;j++){
              if(state[i][j] == 0){
                int result = i * 3  + j;
                return result;
              }
          }
       }
       return -1;
    }

    public boolean isValid(int x,int y){
        if(x < 0 || x >= 3 || y < 0 || y >= 3){
            return false;
        }
        return true;
    }

    public int[][] copy2DArray(int[][] state){
       int[][] result = new int[3][3];
       for(int i = 0;i < 3;i++){
           for(int j = 0;j < 3;j++){
              result[i][j] = state[i][j];
           }
       }
       return result;
    }

    

    
}
