package testTest;

import java.util.LinkedList;
import java.util.Queue;

public class StackLinkedList {
	public Queue q1; 
	public Queue q2; 
	
   public StackLinkedList() {
	   this.q1 = new LinkedList<Integer>();
	   this.q2 = new LinkedList<Integer>();
   }
	
	public void push(int x) {
        // write your code here
		q1.offer(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
    	while(q1.size() > 1) {
    		q2.add(q1.poll());
    	}
    	q1.poll();
    	while(!q2.isEmpty()) {
    		q1.add(q2.poll());
    	}
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
    	int a = 0;
    	while(q1.size() > 1) {
    		q2.add(q1.poll());
    	}
    	a = (int)q1.peek();
    	q2.add(q1.poll());
    	while(!q2.isEmpty()) {
    		q1.add(q2.poll());
    	}
    	return a;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
    	if(q1.isEmpty()) {
    		return true;
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	StackLinkedList s = new StackLinkedList();
    	s.push(1);
    	System.out.println("-----------1");
    	s.push(2);
    	System.out.println("-----------2");
    	s.push(3);
    	System.out.println("-----------3");
    	s.top();
    	System.out.println("-----------4");
    	s.pop();
    	System.out.println("-----------5");
    	s.top();
    	System.out.println("-----------6");
    	s.pop();
    	System.out.println("-----------7");
    	s.top();
    	System.out.println("-----------8");
    	s.isEmpty();
    	System.out.println("-----------9");
    	s.pop();
    	System.out.println("-----------10");
    	s.isEmpty();
    	System.out.println("-----------11");
	}

	public void push_back(int i) {
		// TODO Auto-generated method stub
		
	}
}
