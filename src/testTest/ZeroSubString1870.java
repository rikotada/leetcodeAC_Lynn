package testTest;

public class  ZeroSubString1870 {
    /**
     * @param str: the string
     * @return: the number of substrings 
     */
    public int stringCount(String str) {
        // Write your code here.
        if(str == null ||str.equals("")){
            return 0;
        }
        int n = str.length();
        int i =0,j = 0,result = 0;
        while(i < n){
            while(i < n && str.charAt(i) == '1'){
          
                i++;
            }
            j = Math.max(i+1,j);
            while(j < n && str.charAt(j) == '0'){
                j++;
            }
            //尾部特殊处理
            if(i == n && str.charAt(n-1) == '0'){
                result = result + 1;
                break;
            }
            else if(i == n &&  str.charAt(n-1) == '1'){
                return result;
            }
            result = result + (j-i)*(j-i+1)/2;
            i = j;
        }
        return result;
    }
}
