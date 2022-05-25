package testTest;

public class ValidPalindrome415 {
	 public boolean isPalindrome(String s) {
	        // write your code here
	        if(s == null || s.isEmpty()){
	            return true;
	        }
	        int left = 0,right = s.length()-1;
	        while(left<right){
	            while(left < right && !isLetterOrNum(s.charAt(left))){
	                 left++;
	            }
	            while(left < right && !isLetterOrNum(s.charAt(right))){
	                 right--;
	            }
	           Integer diff = Math.abs(Character.getNumericValue(s.charAt(left)) - Character.getNumericValue(s.charAt(right)));
	           if(diff != 32 && diff != 0){
	              return false;
	           }
	           left++;
	           right--;
	        }
	        return true;
	    }

	    private boolean isLetterOrNum(char c){
	        if(Character.isDigit(c) || Character.isLetter(c)){
	            return true;
	        }
	        return false;
	    }
}
