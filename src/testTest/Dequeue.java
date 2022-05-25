package testTest;

public class Dequeue {
	public ListNode head;
	public ListNode tail;
	public Dequeue() {
	        // do intialization if necessary
		this.head = new ListNode(-1); 
		this.tail = null;
		head.next = tail;
	 }

	    /*
	     * @param item: An integer
	     * @return: nothing
	     */
	    public void push_front(int item) {
	        // write your code here
	    	ListNode a = new ListNode(item);
	    	a.next = head.next;
	    	head.next = a;
	        if(tail == null) {
	        	tail = a;
	        }
	    	
	    }

	    /*
	     * @param item: An integer
	     * @return: nothing
	     */
	    public void push_back(int item) {
	        // write your code here
	    	ListNode a = new ListNode(item);
	    	if(tail == null) {
	    		tail = a;
	    	}
	    	else {
	    		tail.next = a;
	    		tail = a;
	    	}
	    }

	    /*
	     * @return: An integer
	     */
	    public int pop_front() {
	        // write your code here
	    	int a = 0;
	    	if(head.next != null) {
	    		a = head.next.val;
	    		head = head.next;
	    	}
	    	
	    	return a;
	    }

	    /*
	     * @return: An integer
	     */
	    public int pop_back() {
	        // write your code here
	    	if(tail == null) {
	    		return -1;
	    	}
	    	ListNode cur = new ListNode(-1);
	    	cur = head;
	    	while(cur.next != null && cur.next != tail) {
	    		cur = cur.next;
	    	}
	    	int a = 0;
	    	a = tail.val;
	    	cur.next = tail.next;
	    	tail = cur;
	    	return a;
	    }
	    
	  
   class ListNode{
	   public int val;
	   public ListNode next;
	   public ListNode(int val){
		   this.val = val;
	   }
   }
}
