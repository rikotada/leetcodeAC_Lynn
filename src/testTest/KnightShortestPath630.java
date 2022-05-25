package testTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class KnightShortestPath630 {
    public class Pair{
       int a;
       int b;

        Pair(int a,int b){
           this.a = a;
           this.b = b;
       }
   }
   
   public int shortestPath2(boolean[][] grid) {
       // write your code here
       Map<Integer,Integer> map = new HashMap<>();
       map.put(1,2);
       map.put(-1,2);
       map.put(2,1);
       map.put(-2,1);
       if(grid == null){
           return -1;
       }
       int result = 0;
       int a = grid.length - 1;
       int b = grid[0].length -1;
       Queue<Pair> q = new LinkedList<>();
       q.add(new Pair(0,0));
       q.add(null);
       while(!q.isEmpty()){
           Pair p = q.poll();
           if(p != null){
              for(int i = -2;i<3;i++){
                 if(i == 0){
                  continue;
                 }
                 int newA = p.a+i;
                 int newB = p.b+map.get(i);
                 if(newA<=a && 
                    newA>=0 &&
                    newB>=0  &&
                    newB<=b  && 
                    !grid[newA][newB]){
                        grid[newA][newB] = true;
                     q.add(new Pair(newA,newB));
                  }
              }
           }
           else{
              result++;
              if(result >b){
                  break;
              }
             if(q.isEmpty()){
                  break;
              }
             q.add(null);
           }
           if(p != null && p.a == a && p.b == b){
               return result;
           }
       }
       return -1;
   }
}
