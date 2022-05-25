package testTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationWithoutBFSOrDFS15 {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null){
            result.add(new ArrayList<Integer>());
            return result;
        }
        if(nums.length <= 1){
             result.add(copyArray(nums));
             return result;
        }
        int n = nums.length - 1;
        Arrays.sort(nums);
        int[] end = new int[nums.length];
        end = swap(nums);
        result.add(copyArray(nums));
        while(!arrayEqual(end,nums)){
     
            if(nums[n] > nums[n-1]){
                int temp = nums[n];
                nums[n] = nums[n-1];
           
                nums[n-1] = temp;
                result.add(copyArray(nums));
            }
            else{
                int j = n;

                while(j >= 1 && nums[j] <= nums[j-1]){
                    j--;
                }
             
                j = j-1;
                if(j >= 0 ){
                   int min_pivot = findBigger(nums,j);
                   int temp1 = nums[min_pivot];
                   nums[min_pivot] = nums[j];
                   nums[j] = temp1;
                   Arrays.sort(nums,j+1,n+1);
                   result.add(copyArray(nums)); 
                }
                
            }
        }
        return result;
    }
    
    public int findBigger(int[] nums, int start){
        int min = Integer.MAX_VALUE;
        int min_pivot = start;
        int k = start + 1;
        while(k < nums.length && nums[k] > nums[start]){
            if(nums[k] < min){
                min = nums[k];
                min_pivot = k;
            }
            k++;
           
        }
        return min_pivot;
    }
    
    public List<Integer> copyArray(int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            list.add(nums[i]);
        }
        return list;
    }
    
    public int[] swap(int[] nums){
        int[] list = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            list[i] = nums[nums.length - 1 - i];
        }
        return list;
    }
    
    public  boolean arrayEqual(int[] a, int[] b){
        int n = a.length;
        for(int i = 0;i< n;i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
    
}
