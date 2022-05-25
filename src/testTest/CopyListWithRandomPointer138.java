package testTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyListWithRandomPointer138  {
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node dummy = new Node(-1);
        Node pointer = head;
        Node anotherp = dummy;
        Map<Node,Integer> map = new HashMap<>();
        List<Node> list = new ArrayList<>();
        int index = 0;
        while(pointer != null){
            Node n = new Node(pointer.val);
            map.put(pointer,index);
            list.add(n);
            index++;
            anotherp.next = n;
            anotherp = anotherp.next;
            pointer = pointer.next;
        }
        Node pointer2 = head;
        int anotherIndex = 0;
        while(pointer2 != null){
            Node r = pointer2.random;
            Node n = list.get(anotherIndex);
            if(r == null){
                n.random = null;
            }
            else{
               int i = map.get(r);
               Node ran = list.get(i);
               n.random = ran;
            }
            anotherIndex++;
            pointer2 = pointer2.next;
            
        }
        return dummy.next;
        
    }
}