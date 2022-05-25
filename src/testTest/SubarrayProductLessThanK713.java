package testTest;

public class SubarrayProductLessThanK713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            //不完全回退到零
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            //每走一步就加一下
            //只会新加入含有最右边元素的子串
            ret += j - i + 1;
        }
        return ret;
    }
}


