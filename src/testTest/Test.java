package testTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args){
        boolean result = checkCardNum("账 号 4367**+xD5227 志","4367831000395227");
        System.out.println(result);
        boolean result2 = checkCardNum("回 单 编 号 0032-9187-0343-0175","6214000000004133");
        System.out.println(result2);
        Map<TreeNode,Set<TreeNode>> map = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
        map.put(new TreeNode(1),set);

    }
    
    public static boolean checkCardNum(String line,String receiveCardNum) {
    	String maybeCardNum = line.replaceAll(" ", "");
    	String originalLineWithoutBlank = new String(maybeCardNum);
		maybeCardNum = maybeCardNum.replaceAll("[^0-9]", " ");
		maybeCardNum = maybeCardNum.replaceAll(" +"," ");
		String pureNum = maybeCardNum.replace(" ", "");
		if(pureNum.length() == 19 || pureNum.length() == 16) {
			return pureNum.equals(receiveCardNum) ? true : false;
		}
		String startNum = "";
		String endNum = "";
		String[] nums = maybeCardNum.split(" ");
		System.out.println(nums.length);
		int length = nums.length;
		for(int i = 0;i < length;i++) {
			if(nums[i].length() == 0) {
				continue;
			}
			if(startNum.length() == 0) {
				startNum = nums[i];
			}
		}
        if(nums.length == 0) {
        
			return false;
		}
		endNum = nums[length-1];
		System.out.println("startNum: "+startNum);
		System.out.println("endNum: "+endNum);
		int startNumDigit = startNum.length();
		if(startNum.equals(endNum)) {
			return receiveCardNum.substring(0, startNumDigit).equals(startNum) ? true : false;
		}
		
		int endNumDigit = endNum.length();
		int receiveLength = receiveCardNum.length();
		int a = originalLineWithoutBlank.lastIndexOf(startNum.substring(startNumDigit - 1, startNumDigit));
		if(receiveCardNum.substring(0, startNumDigit).equals(startNum)) {
			if(a < originalLineWithoutBlank.length() - 1 && endNumDigit < 4) {
				return true;
			}
			else if(receiveCardNum.substring(receiveLength - endNumDigit, receiveLength).equals(endNum)){
				return true;
			}
		}
		return false;
	}
}
