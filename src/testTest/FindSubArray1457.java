package testTest;

import java.util.HashMap;
import java.util.Map;

public class FindSubArray1457 {
  public int searchSubArray(int arr[], int k) {
	  Map<Long,Integer> map = new HashMap<>();
	  map.put((long)0, 0);
	  long prefix = 0;
	  for(int i = 0;i<arr.length;i++) {
		  prefix = prefix + arr[i];
		  if(map.containsKey(prefix - k)) {
			  return i - map.get(prefix - k) +1;
		  }
		  //防止顶替掉最小的坐标
		if(!map.containsKey(prefix)) {
			map.put(prefix,i+1);
		}
	  }
	  return -1;
  }
}
