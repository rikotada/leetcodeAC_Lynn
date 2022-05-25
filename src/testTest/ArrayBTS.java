package testTest;

public class ArrayBTS {
	public TreeNode sortedArrayToBST(int[] A) {
        // write your code here
//		TreeNode n = helper(A);
		TreeNode n = helper(A,0,A.length -1);
		return n;
    }
	
//	private TreeNode helper(int[] b) {
//	    if(b.length == 0) {
//	    	return null;
//	    }
//	    Integer mid = b.length / 2;
//	    int[] leftArray = b;
//	    int[] rightArray = b;
//	    if(mid != 0) {
//	    	leftArray = subArray(b,0,mid-1);
//	    	if(mid+1 > b.length -1) {
//	    		rightArray = new int[0];
//	    	}
//	    	else {
//	    		rightArray = subArray(b,mid+1,b.length-1);
//	    	}
//	  	    
//	    }
//	  
//	    TreeNode newNode = new TreeNode(b[mid]);
//	    if(leftArray.equals(rightArray)) {
//	    	return newNode;
//	    }
//	    newNode.left = helper(leftArray);
//	    newNode.right = helper(rightArray);
//		
//		return newNode;
//	}
//	
//	private int[] subArray(int[] a, int start, int end) {
//		int i = 0;
//		int[] res = new int[end - start + 1];
//		for(i = 0;i<end - start + 1;i++) {
//			res[i] = a[start+i];
//		}
//		return res;
//	}
	
	private TreeNode helper(int[] b,int start,int end) {
		if(start >= end) {
			return null;
		}
		int mid = (start + end)/2;
		TreeNode node = new TreeNode(b[mid]);
		node.left = helper(b,start,mid-1);
		node.right = helper(b,mid+1,end);
		return node;
	}
}
