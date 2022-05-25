package testTest;

import java.util.Arrays;
import java.util.Comparator;

public class TheCompetitionOfView287 {
    /**
     * @param pos: the vision ward can control interval
     * @param L: you need to control interval length
     * @return: return the minium number of vision ward to control the interval
     */
    public int getMiniumVisionWard(int[][] pos, int L) {
        // write your code here
        if(pos == null ||pos.length == 0){
            return -1;
        }
        Arrays.sort(pos,new Comparator<int[]>(){
            public int compare(int[] o1,int[] o2){
               if(o1[0] != o2[0]){
                   return o1[0] - o2[0];
               }
               return o2[1] - o1[1];
            }
        });
        if(pos[0][0] != 0){
           return -1;
        }
        int boundary = pos[0][1];
        int step = 1;
        int len = pos.length;
        int maxRight = 0;
        for(int i = 1;i < len;i++){
            if(boundary >= L){
                break;
            }     
            boolean continue1 = false;
            while(i< len && pos[i][0] <= boundary){                
                if(pos[i][1] > maxRight){
                    continue1 = true;
                    maxRight = pos[i][1];
                }
                i++;
            }
            if(!continue1){
               return -1;
            }
            i--;
            step++;
            boundary = maxRight;
        }

        return step;
    }
}
