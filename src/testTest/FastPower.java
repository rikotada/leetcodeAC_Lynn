package testTest;

public class FastPower {
	public int fastPower(int a, int b, int n) {
	     if(a == 1 || a == 0) {
	    	 return a;
	     }
	     if(n == 0){
	        return 1%b; 
	     }
	     a = a % b;
		 long[] arr = new long[n+1]; 
	     arr[0] = 1;
	     arr[1] = a;
        long result = helper(a,n,arr,b);
        result = result % b;
		 return (int)result;
	  }
	 
	 private long helper(long a, int n, long[] arr, int divide) {
		 if(n == 1 || n == 0) {
			 return arr[n];
		 }
		 if(arr[n] != 0) {
			 return arr[n];
		 }
		 Integer mid = n / 2;
		 Integer anoMid = n - mid;
		 long res = helper(a,mid,arr,divide) * helper(a,anoMid,arr,divide);
		 res = res % divide;
		 arr[n] = res;
		 
		 return arr[n];
	 }
}
