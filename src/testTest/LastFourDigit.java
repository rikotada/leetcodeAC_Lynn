package testTest;

public class LastFourDigit {
	 public int lastFourDigitsOfFn(int n) {
	        // write your code here
		 if(n == 0) {
			 return 0;
		 }
		 int[] arr = new int[n+1];
		 arr[1] = 1;
		 arr[2] = 1;
		 int a = helper(n,arr);
		 return a;
	 }
	 
	 private int helper(int n,int[] arr) {
		 if(n == 1 || n == 2) {
			 return arr[n];
		 }
		 if(arr[n]!=0) {
			 System.out.println("n = "+n+" arr[n] = "+arr[n]);
			 return arr[n];
		 }
		 Integer i = helper(n-1,arr)+helper(n-2,arr);
		 if(i >= 10000) {
            i = i % 10000;
		 }
		 arr[n] = i;
		 return arr[n];
	 }
	 

	 public static void main(String[] args) {
		 LastFourDigit lfg = new LastFourDigit();

		 lfg.lastFourDigitsOfFn(5531354);
					
	  }
	 
	
	 
	 
}
