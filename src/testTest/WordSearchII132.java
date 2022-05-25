package testTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII132 {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        List<String> result = new ArrayList<>();
        if(board == null || board.length  == 0){
            return result;
        }
        int rows = board.length;
        int columns = board[0].length;
        int maxLength = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        for(String w:words){
           if(w.length() > maxLength){
              maxLength = w.length();
           }
        }
        int[] xDelta = {1,-1,0,0};
        int[] yDelta = {0,0,1,-1};
        for(String word:words){
            for(int i = 0;i < rows;i++){
               for(int j = 0;j < columns;j++){
                  String s  = Character.toString(board[i][j]);
                  boolean[][] visited = new boolean[rows][columns];
                  visited[i][j] = true;
                  dfs(0,board,maxLength,visited,xDelta,yDelta,i,j,word,s,set);
                }
            }
        }
        for(String s:set){
            result.add(s);
        }
        return result;
    }
    public void dfs(int index,char[][] board,int maxLength,boolean[][] visited,int[] xDelta,int[] yDelta,int startX,int startY,String word,String current,Set<String> result){
        if(word.charAt(index) != board[startX][startY]){
            return;
        }
        if(word.equals(current)){
           result.add(current);
           return;
        }
        for(int i = 0;i < 4;i++){
           int newX = xDelta[i] + startX;
           int newY = yDelta[i] + startY;
           if(newX < 0 || 
              newX >= board.length ||
              newY < 0 || 
              newY >= board[0].length || 
              visited[newX][newY] ||
              current.length() >= maxLength){
              continue;
           }
           current = current + board[newX][newY];
           visited[newX][newY] = true;      
           dfs(index+1,board,maxLength,visited,xDelta,yDelta,newX,newY,word,current,result);
           current = current.substring(0, current.length()-1);
           visited[newX][newY] = false;
        }
        return;
    }
}
