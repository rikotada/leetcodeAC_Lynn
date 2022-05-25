package testTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetBinary {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
	//基于进制转换的方法
	//思路就是使用一个 正整数的二进制表示 的第 i 位是 1 还是 0 来代表集合的第 i 个数取或者不取。因为从 0 到 2^n - 1 总共 2^n 个整数，正好对应集合的 2^n 个子集。
	//比如 {1，2，3} 的子集可以用 0 到 7 来表示
	//0 -> 000 -> {}
	//1 -> 001 -> {3}
	//2 -> 010 -> {2}
	//3 -> 011 -> {2,3}
	//4 -> 100 -> {1}
	//5 -> 101 -> {1,3}
	//6 -> 110 -> {1,2}
	//7 -> 111 -> {1,2,3}
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        
        return result;
    }
}
