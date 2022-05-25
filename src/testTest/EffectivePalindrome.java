package testTest;

public class EffectivePalindrome {
	 /**
	  * @param s: a string
	  * @return: whether you can make s a palindrome by deleting at most one character
	  */
	 public boolean validPalindrome(String s) {
	     // Write your code here
	     if(s == null){
	         return false;
	     }
	        
	     Integer left = 0, right = s.length() - 1;
	     Pair pair = new Pair(left,right);
	     if(isPalindrome(s,pair)){
	         return true;
	     }
	     return isPalindrome(s,new Pair(pair.left + 1,pair.right)) ||isPalindrome(s,new Pair(pair.left,pair.right-1));
	 }
	 class Pair{
	     private Integer left;
	     private Integer right;
	     public Pair(Integer left, Integer right){
	         this.left = left;
	         this.right = right;
	     }
	     public void setLeft(Integer left){
	         this.left = left;
	     }
	     public void setRight(Integer right){
	         this.right = right;
	     }
	 }
	    
	 private Boolean isPalindrome(String s, Pair pair){
	     Integer left = pair.left;
	     Integer right = pair.right;
	        
	     while(left < right){
	         if(s.charAt(left) != s.charAt(right)){
	             break;
	         }
	         left++;
	         right--;
	     }
	     pair.setLeft(left);
	     pair.setRight(right);
	     return left >= right;
	 }
	  

}
