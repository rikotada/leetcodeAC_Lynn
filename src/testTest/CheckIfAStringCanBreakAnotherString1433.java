package testTest;

import java.util.Arrays;


public class CheckIfAStringCanBreakAnotherString1433 {
    public boolean checkIfCanBreak(String s1, String s2) {
        int len = s1.length();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        boolean a = check(len,arr1,arr2);
        boolean b = check(len,arr2,arr1);

        if(!a && !b){
           return false;
        }
        return true;
    }

    public boolean check(int len,char[] arr1,char[] arr2){
         for(int i = 0;i < len;i++){
            if((int)arr1[i] - (int)arr2[i] < 0){
                return false;
            }
         }
         return true;
    }
}
