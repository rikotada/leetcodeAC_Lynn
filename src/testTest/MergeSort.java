package testTest;

public class MergeSort {
   public int[] MergeSortArray(int[] a, int[]b) {
	   if(a == null) {
		   return b;
	   }
	   if(b == null) {
		   return a;
	   }
	   
	   int lenA = a.length,lenB = b.length;
	   int n = lenA + lenB;
	   int[] result = new int[n];
	   int i = 0,j = 0;
	   for(int k = 0;k < n;k++) {
		   if(i<lenA &&(j>=lenB ||a[i]<=b[j])) {
			   result[k] = a[i++];
		   }
		   else {
			   result[k] = b[j++];
		   }
	   }
	   return result;
   }
}
