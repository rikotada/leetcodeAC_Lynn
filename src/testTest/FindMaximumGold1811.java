package testTest;

import java.util.HashSet;
import java.util.Set;

public class FindMaximumGold1811 {
    /**
     * @param grids: a integer two-dimensional array
     * @return: return the maximum sum of golds 
     */
    int result = 0;
    int[] xChange = {0,0,1,-1};
    int[] yChange = {1,-1,0,0};
    public int FindMaximumGold(int[][] grids) {
        // write your code here
        if(grids == null || grids[0].length == 0){
             return 0;
        }
        int x = grids.length;
        int y = grids[0].length;
        Set<String> visited = new HashSet<>();
        for(int i = 0;i < x;i++){
           for(int j = 0;j < y;j++){
              if(grids[i][j] != 0){
                 visited.add(i+"_"+j);
                 helper(grids,i,j,visited,grids[i][j]);
              }
              visited.clear();
           }
        }
        return result;
    }

    public void helper(int[][] grids,int x,int y,Set<String> visited,int current){

        for(int i = 0;i < 4;i++){
            if(isValid(grids,x + xChange[i],y + yChange[i],visited)){
                int newx = x + xChange[i];
                int newy = y + yChange[i];
                String s = newx+"_"+newy;
                visited.add(s);
                helper(grids,newx,newy,visited,current + grids[newx][newy]);
                visited.remove(s);
            }
        }
        if(current > result){
           result = current;
        }
        return;
    }

    public boolean isValid(int[][] grids,int newx,int newy,Set<String> visited){
        if(newx < 0 || newx >= grids.length || newy < 0 || newy >= grids[0].length){
            return false;
        }
        if(grids[newx][newy] == 0){
            return false;
        }
        if(visited.contains(newx+"_"+newy)){
            return false;
        }
        return true;
    }
}
