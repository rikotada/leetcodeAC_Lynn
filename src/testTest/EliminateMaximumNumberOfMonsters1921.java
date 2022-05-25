package testTest;

import java.util.Arrays;

public class EliminateMaximumNumberOfMonsters1921  {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = speed.length;
        double[] time = new double[n];
        for(int i = 0;i < n;i++){
            time[i] = (double)dist[i] / (double)speed[i];
        }
        Arrays.sort(time);
        for(int i = 0;i < n;i++){
            if(time[i] <= i){
                return i;
            }
        }
        return n;
    }
}
