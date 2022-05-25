package testTest;

public class SearchInABigSortedArray447 {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     * 
     */
	class ArrayReader{
		int get(int i) {
			return i;
		}
	}
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int left = 0;
        int right = 1;
        while(reader.get(right) < 2147483647 ){
            right = 2 * right;
        }
        while(left + 1 < right){
             int mid = (right + left) / 2;
             if(reader.get(mid) >= target){
                 right = mid;
             }
             else{
                 left = mid;
             }
        }

        if(reader.get(left) == target){
            return left;
        }
        if(reader.get(right) == target){
            return right;
        }
        return -1;
    }
}
