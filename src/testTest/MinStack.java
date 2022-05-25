package testTest;

import testTest.Dequeue.ListNode;

public class MinStack {
	  public ListNode head;
	  public ListNode minNode;
	  public Integer min;
	  public MinStack() {
	        // do intialization if necessary
		  this.head = new ListNode(-1);
		  this.minNode = new ListNode(-2);
		  this.min = 100000000;
		  head.next = null;
		  
	  }

	    /*
	     * @param number: An integer
	     * @return: nothing
	     */
	    public void push(int number) {
	        // write your code here
	    	ListNode a = new ListNode(number);
	    	a.next = head.next;
	    	head.next = a;
	    	if(number<=min) {
	    		min = number;
	    		ListNode b = new ListNode(min);
	    		b.next = minNode.next;
	    		minNode.next = b;
	    	}
	    }

	    /*
	     * @return: An integer
	     */
	    public int pop() {
	        // write your code here
	    	int a = 0;
	    	if(head.next != null) {
	    		a = head.next.val;
	    		head.next = head.next.next;
	    	}
	    	if(minNode.next!= null && a == minNode.next.val) {
	    		minNode.next = minNode.next.next;
	    		if(minNode.next != null) {
	    			min = minNode.next.val;
	    		}
	    		else {
	    			min = 100000000;
	    		}
	    		
	    	}
	    	return a;
	    }

	    /*
	     * @return: An integer
	     */
	    public int min() {
	        // write your code here
	    	return min;
	    }
	    
	    class ListNode{
	 	   public int val;
	 	   public ListNode next;
	 	   public ListNode(int val){
	 		   this.val = val;
	 	   }
	    }
}


