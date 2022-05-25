package testTest;



import testTest.Dequeue.ListNode;

public class Main {

	public static void main(String[] args) {
		
		Dequeue s = new Dequeue();
		ListNode r = s.head;
		s.push_back(754);
		s.pop_front();

		s.push_front(234);
		s.pop_back();
		
		s.push_back(739);
		s.push_back(955);
		s.pop_front();
		s.pop_front();
		
		s.push_back(625);
		s.push_back(467);
		s.pop_back();
		s.pop_front();
		
		s.push_back(518);
		s.pop_back();
		
		s.push_front(591);
		s.pop_front();
		
		s.push_back(772);
		s.push_back(934);
		s.pop_front();
		s.pop_front();
		
		s.push_front(566);
		s.pop_back();
		
		s.push_back(987);
		s.push_front(390);
		s.pop_front();
		s.pop_back();
		
		s.push_back(571);
		s.push_back(88);
		s.push_back(39);
		s.pop_front();
		   r = s.head;
		   while(r!=null) {
			System.out.println("remove571----"+r.val);
			r = r.next;
		   }
		   System.out.println("remove571 head----"+s.head.val); 
		   System.out.println("remove571 tail----"+s.tail.val);  
		s.push_front(441);
		   r = s.head;
		   while(r!=null) {
			System.out.println("add441----"+r.val);
			r = r.next;
		   }
		   System.out.println("add441 head----"+s.head.val); 
		   System.out.println("add441 tail----"+s.tail.val);
		s.pop_back();
		   r = s.head;
		   while(r!=null) {
			System.out.println("1----"+r.val);
			r = r.next;
		   }
		
		s.pop_back();
		   r = s.head;
		   while(r!=null) {
			System.out.println("2----"+r.val);
			r = r.next;
		   }
		s.pop_back();
		    r = s.head;
		    while(r!=null) {
			System.out.println("3----"+r.val);
			r = r.next;
		    }
		s.push_front(396);
		s.pop_front();
		s.push_front(603);
		s.push_front(922);
		s.pop_back();
		s.pop_back();
		s.push_front(118);
		s.pop_front();
		s.push_front(94);
		s.pop_front();
		s.push_back(653);
		s.pop_back();
		s.push_front(352);
		s.push_back(531);
		s.pop_front();
		s.pop_back();
		s.push_front(883);
		s.pop_front();
		s.push_front(756);
		s.pop_back();
		s.push_front(690);
		s.pop_back();
		s.push_back(68);
		s.pop_front();
		s.push_back(829);
		s.pop_front();
	}
    
	
	
	  
	

}
