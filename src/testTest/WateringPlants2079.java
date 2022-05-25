package testTest;

public class WateringPlants2079 {
    public int wateringPlants(int[] plants, int capacity) {
        int result = 0;
        int len = plants.length;
        int left = capacity;
        for(int i = 0;i < len;i++){
            if(left >= plants[i]){
                result++;
                
            }
            else{
                result = result + 2 * i + 1;
                left = capacity;
            }
            left -= plants[i];
        }

        
        return result;
    }
}
