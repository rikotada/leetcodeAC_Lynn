package testTest;

import java.util.LinkedList;
import java.util.List;

public class FindAllNumbersDisappearedInArray448{
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        //停止的条件是什么？不是坐标和num的值相等 而是没得可换了（目标和当前值相等）
        for(int i = 0;i < len;i++){
            while(nums[i] != nums[nums[i] - 1]){               
                swap(nums,i,nums[i] - 1); 
            }
        }
        List<Integer> result = new LinkedList<>();
        for(int i = 0;i < len;i++){
           if(nums[i] != i + 1){
               result.add(i + 1);
           }
        }
        return result;
    }

    public void swap(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp; 
    }
}
