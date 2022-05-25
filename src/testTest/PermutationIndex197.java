package testTest;

public class PermutationIndex197 {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
	//只需计算有多少个排列在当前排列A的前面即可。如何算呢?
	//举个例子，[3,7,4,9,1]，在它前面的必然是某位置i对应元素比原数组小，而i左侧和原数组一样。
	//也即 [3,7,4,1,X] ， [3,7,1,X,X] ， [3,1或4,X,X,X] ， [1,X,X,X,X] 。
	//而第 i 个元素，比原数组小的情况有多少种，其实就是 A[i] 右侧有多少元素比 A[i] 小，乘上 A[i] 右侧元素全排列数，即 A[i] 右侧元素数量的阶乘。
	//i 从右往左看，比当前 A[i] 小的右侧元素数量分别为 1,1,2,1，
	//所以最终字典序在当前 A 之前的数量为 1×1!+1×2!+2×3!+1×4!=39 ，故当前 A 的字典序为 40。
	
	//Q：元素有重复怎么办？
	//A：好问题！元素有重复，情况会复杂的多。因为这会影响 A[i] 右侧元素的排列数，此时的排列数计算方法为总元素数的阶乘，除以各元素值个数的阶乘，
	//例如 [1, 1, 1, 2, 2, 3] ，排列数为6! ÷ (3! × 2! × 1!) 。
	//为了正确计算阶乘数，需要用哈系表记录 A[i] 及右侧的元素值个数，并考虑到 A[i] 与右侧比其小的元素 A[k] 交换后，要把 A[k] 的计数减一。
	//用该哈系表计算正确的阶乘数。而且要注意，右侧比 A[i]小 的重复元素值只能计算一次，不要重复计算！
    public long permutationIndex(int[] a) {
        // write your code here
        if(a == null || a.length < 2){
            return 1;
        }
        int i = 0;
        long count = 0;
        for(i = 0;i < a.length;i++){
            int b = findSmallerNum(a,i);
            long c = factorial(a.length-i-1); 
            count = count + b * c; 
            System.out.println("b: "+b+" f:"+ c);
        }
        return count+1;
    }
    public int findSmallerNum(int[] nums, int start){
        int count = 0;
        int i = 0;
        for(i = start+1;i < nums.length;i++){
            if(nums[i] < nums[start]){
                count++;
            }
        }
        return count;
    }
    
    public long factorial(int n){
        long result = 1;
        for(int i = n; i > 0; i--){
            result = result * i;
        }
        return result;
    }
}
