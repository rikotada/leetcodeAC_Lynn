package testTest;

public class CarPooling1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] capacityChanges = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            capacityChanges[trips[i][1]] -= trips[i][0];
            capacityChanges[trips[i][2]] += trips[i][0];
        }

        for (int i = 0;i < capacityChanges.length;i++) {
            capacity += capacityChanges[i];
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }

}