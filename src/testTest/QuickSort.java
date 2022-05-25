package testTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class QuickSort {
  public static void quickSort1(int[] array) {
	  helper(array,0,array.length - 1);
  }
  private static void swap(int[] array, int i, int j) {
	  int tmp = array[i];
	  array[i] = array[j];
	  array[j] = tmp;
  }
  
  
  public static void testQuickSort() {
	  int len = 100;
	  int[] arr = new int[len];
	  Random random = new Random();
	  Map<Integer,Integer> freq = new HashMap<>();
	  for(int i = 0;i < len;++i) {
		 int num  = random.nextInt();
		 arr[i] = num;
		 
		 if(freq.containsKey(num)) {
			 freq.put(num, freq.get(num)+1);
		 }
		 else {
			 freq.put(num,1);
		 }
	  }
	  QuickSort.quickSort1(arr);
	  if(arr.length != len) {
		  System.out.println("failed");
		  return;
	  }
	  
	  Map<Integer,Integer> newFreq = new HashMap<>();
	  for(int i = 0;i < len;++i) {
		  int number = arr[i];
		  if(newFreq.containsKey(number)) {
				 freq.put(number, freq.get(number)+1);
			 }
		  else {
				 newFreq.put(number,1);
		  }
	  }
	  
	  if(!freq.equals(newFreq)) {
		  System.out.println("failed");
		  return;
	  }
	  
	  for(int i = 0;i < len;++i) {
		  if(arr[i] < arr[i-1]) {
			  System.out.println("failed");
		  }
	  }
	  System.out.println("succeed");
  }
  public static void helper(int[] array, int left, int right) {
	  if(left>=right) {
		  return;
	  }
	  int i = left,j = right;
	  int pivot = array[left+(right-left)/2];
	  
	  while(i <= j) {
		  while(i <= j && array[i] < pivot) {
			  ++i;
		  }
		  while(i <= j && array[j] > pivot) {
			  --j;
		  }
		  if(i <= j) {
			  swap(array,i,j);
			  i++;
			  j--;
		  }

	  }
	   helper(array,left,j);
	   helper(array,i,right);
  }
}
