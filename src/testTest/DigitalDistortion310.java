package testTest;

public class DigitalDistortion310 {
    /**
     * @param A: the integer discrible in problem
     * @return: the integer after distortion
     */
    public String Distortion(String A) {
        // 
        if(A == null || A.length() <= 1){
           return A;
        }
        int left = 0;
        int right = A.length() - 1;
        StringBuilder sb  = new StringBuilder();
        while(left < right){
            sb.append(A.charAt(right));
            right--;
            sb.append(A.charAt(left));
            left++;
        }
        if(left == right){
             sb.append(A.charAt(left));
        }
        String result = sb.toString();
        return result;
    }
}
