package testTest;

import java.util.ArrayList;
import java.util.List;

public class NQueensDFS33 {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    class Pair{
        public int x;
        public int y;
        public Pair(int x,int y){
           this.x = x;
           this.y = y;
        }
    }
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if(n == 0){
            result.add(new ArrayList<String>());
          return result;
        }
        for(int i = 0; i<n;i++){
          List<Pair> listP = new ArrayList<Pair>();
          dfs(n,0,i,listP,result);
        }

        return result;
    }
    public void dfs(int n, int x, int y, List<Pair> single, List<List<String>> result){
    	//DFS过程 
    	//1.不可行return
         if(!isValid(x,y,single)){
            return;
         }
         //2.把去过的路径添加到现有路径里
         Pair p = new Pair(x,y);
         single.add(p);
         //3.到头了 把路径添加到路径集合里 再回溯 return
         if(x == n-1){
            result.add(convertToString(single,n));
            single.remove(p);
            return;
         }
         //4.对于所有选项枝 dfs循环
         for(int i = 0; i < n;i++){
            dfs(n,x+1,i,single,result);
         }
         //不要忘记回溯
         single.remove(p);
    }
    public boolean isValid(int x, int y,List<Pair> existed){
        for(Pair p:existed){
           if(p.x == x){
             return false;
           }
           if(p.y == y){
              return false;
           }
           if((p.y-p.x) == (y-x)){
              return false;
           }
           if((p.y+p.x) == (x + y)){
              return false;
           }
        }
        return true;
    }

    public List<String> convertToString(List<Pair> list, int n){
           StringBuilder s = new StringBuilder("");
           List<String> result = new ArrayList<String>();
           for(Pair p : list){
              for(int i = 0; i < n; i++){
                  if(i == p.y){
                     s.append("Q");
                  }
                  else{
                      s.append(".");
                  }
              }
              result.add(s.toString());
              s = new StringBuilder("");
           }
        return result;  
    }
}
