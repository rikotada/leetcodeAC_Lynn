package testTest;

import java.util.Arrays;

public class FriendsOfAppropriateAges1393 {
    /**
     * @param ages: 
     * @return: nothing
     */
    public int numFriendRequests(int[] ages) {
        if(ages == null || ages.length == 0 ){
             return 0;
	   }
	   int result = 0;
	   Arrays.sort(ages);
	   int len = ages.length;
	   // 大于a 小于等于自己
	   for(int i = 0;i < len;i++){
            if(ages[i] <= 14){
               continue;
		  }
		  int a = ages[i] / 2 + 7 + 1;
            int index = binary(ages,0,i,a);
		  int k = i;
		  if(ages[len - 1] == ages[i]){
               k = len - 1;
		  }
		  else{
               while(k < len && ages[k] == ages[i]){
                   k++;
		     }
			k--;
		  }
		  result += k - index;

 	   } 
         return result;

    }

    public int binary(int[] ages,int start,int end,int val){
	     int left = start;
		int right = end;
          while(left + 1 < right){
              int mid = (right - left) / 2 + left;
		    if(ages[mid] >= val){
                  right = mid;
		    }
		    else{
			    left = mid;
		    }
		}
		if(ages[left] >= val){
              return left;
		}
		return right;
    }
}
