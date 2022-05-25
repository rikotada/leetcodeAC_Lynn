package testTest;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers386 {
    public List<Integer> lexicalOrder(int n) {
      List<Integer> result = new ArrayList<>();
      for(int i = 1;i <= 9;i++){
            add(result,n,i);   
      }
      return result;
    }

    public void add(List<Integer> list,int limit,int current){
        if(current > limit){
             return;
        }
        list.add(current);
        for(int i = 0;i < 10;i++){
            add(list,limit,current * 10 + i);      
        }
        
        return;
    }
}