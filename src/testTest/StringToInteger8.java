package testTest;

import java.util.HashSet;
import java.util.Set;

public class StringToInteger8  {
    public int myAtoi(String str) {
        long result = 0;
         int len = str.length();
         int i = 0;
         Set<Character> nums = new HashSet<>();
         for(i = 0;i < 10;i++){
            nums.add((char)(i + '0'));
         }
         i = 0;
         while(i < len && str.charAt(i) == ' '){
            i++;
         }
         if(i == len){
            return 0;
         }
         char start = str.charAt(i);
         boolean plus = true;
         if(!nums.contains(start) && start != '+' && start != '-'){
             return 0;
         }
         if(start == '+'){
            i++;
         }
         if(start == '-'){
            plus = false;
            i++;
         }
         for(int j = i;j < len;j++){
              if(!nums.contains(str.charAt(j))){
                   break;
              }
              result = result * 10 + str.charAt(j) - '0';
              if(plus && result  > Integer.MAX_VALUE){
                 return Integer.MAX_VALUE;
              }
              else if(!plus && (result * -1) < Integer.MIN_VALUE){
                 return Integer.MIN_VALUE;
              }              
         }
         return plus ? (int)result : (int)(result * -1);

    }
}
