package testTest;

public class ProjectionAreaOf3DShapes883 {
    public int projectionArea(int[][] grid) {
        int base = 0;
        int sideA = 0;
        int sideB = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i < m;i++){
            int rowM = 0;
            int colM = 0;
            for(int j = 0;j < n;j++){
                if(grid[i][j] != 0){
                    base++;
                }
                rowM = Math.max(rowM,grid[i][j]);  
                colM = Math.max(colM,grid[j][i]);             
            }
            sideA += rowM;
            sideB += colM;
        }
        return sideA + sideB + base;

    }
}