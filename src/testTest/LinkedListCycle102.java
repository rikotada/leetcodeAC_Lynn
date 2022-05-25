package testTest;

public class LinkedListCycle102 {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
           slow = slow.next;
           fast = fast.next;
           if(fast == null){
               return false;
           }
           fast = fast.next;
           if(slow == fast){
               break;
           }
        }
        return fast == null ? false : true;
    }
}
