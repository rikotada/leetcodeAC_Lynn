package testTest;

import java.util.HashMap;
import java.util.Map;

public class Triangle {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
 
    public int minimumTotal(int[][] triangle) {
        // write your code here
        Map<Integer,Integer> map = new HashMap<>();
        return divide(0,0,triangle,map);
       
        
    }
    
    private int divide(int x,int y,int[][] triangle, Map<Integer,Integer> map){
        if(x == triangle.length){
            return 0;
        }
        int key = x * triangle.length + y;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int left = divide(x+1,y,triangle,map);
        int right = divide(x+1,y+1,triangle,map);
        int min = Math.min(left,right) + triangle[x][y];
        map.put(key,min);
        return min;
    }
}
