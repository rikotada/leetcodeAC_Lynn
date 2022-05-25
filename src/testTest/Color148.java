package testTest;


public class Color148 {
  public int[] sortColors(int[] nums) {
	  if(nums == null || nums.length == 0) {
		  return nums;
	  }
	  int n = nums.length;
	  int[] colorCount = new int[3];
	  for(int i = 0;i <n;i++) {
		  colorCount[nums[i]]++;
	  }
	  int base = 0;
	  for(int i = 0;i < 3;i++) {
		  int count = colorCount[i];
		  if(i > 0) {
			  base = colorCount[i-1] + base;
		  }
		  for(int j= 0;j < count;j++) {
			  nums[j+base] = i;
		  }
	  }
	  return  nums;
  }
  
  public void sortColorsOfficial(int[] nums) {
	  if(nums == null || nums.length == 0) {
		  return;
	  }
	  int n = nums.length;
	  int[] colorCount = new int[3];
	  for(int i = 0;i <n;i++) {
		  colorCount[nums[i]]++;
	  }
	  int base = 0;
	  for(int i = 0;i < 3;i++) {
		  int count = colorCount[i];
		 for(int j = 0;j < count;j++) {
			 nums[base++] = i;
		 }
	  }
  }
  
	 public static void main(String[] args) {
	     int[] a = {2,1,0,2,2,1,0,0,1,2};
	     Color148 b = new Color148();

	     b.sortColors(a);
	     for(int i = 0;i < a.length;i++) {
	    	 System.out.print(a[i]+"");
	     }

	     
					
	  }
}
