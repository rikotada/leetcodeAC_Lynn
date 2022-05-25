package testTest;

public class RotateStringII1790 {
    /**
     * @param str: An array of char
     * @param left: a left offset
     * @param right: a right offset
     * @return: return a rotate string
     */
    public String RotateString2(String str, int left, int right) {
        // write your code here
        if(str == null || str.length() == 0 || left == right){
            return str;
        }
        int toLeft = left - right;
        int length = str.length();
        if(toLeft % length == 0){
           return str;
        }
        if(toLeft > 0){
            toLeft = toLeft % length;
            return str.substring(toLeft, length)+str.substring(0, toLeft);
        }
        else{
            int toRight =  -1 * toLeft;
            toRight = toRight % length;
            return str.substring(length - toRight, length)+str.substring(0, length - toRight);
        }
    }
}
