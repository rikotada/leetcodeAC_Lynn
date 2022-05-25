package testTest;

public class UniquePathNotDP114 {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        long Amn = 1;
        int i = 1;
        int j = 1;
        int k = 1;
        for(i = 1;i<=m+n-2;i++){
           Amn = Amn * i;
           if(Amn % j == 0 && j < m){
              Amn = Amn / j;
              j++;
           }
           if(Amn % k == 0 && k < n){
              Amn = Amn / k;
              k++;
           }
        }
        return (int)Amn;
    }
}
