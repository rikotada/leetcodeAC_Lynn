package testTest;

import java.util.Collections;
import java.util.List;

public class MergeKSortedLists104 {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     * O(nK*slogK)
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        lists.remove(null);
        if(lists.size() == 0){
           return null;
        }
        while(lists.size() > 1){
            lists = helper(lists,0,lists.size() - 1);
            lists.remove(null);
        }
        return lists.get(0);
    }

    public List<ListNode> helper(List<ListNode> list,int index1,int index2){
        if(index1 >= index2 || list.size() == 1){
            return list;
        }
        list = helper(list,index1 + 1,index2 - 1);        
        ListNode pointer1 = list.get(index1);
        ListNode pointer2 = list.get(index2);
        if(pointer1 == null && pointer2 != null){
           Collections.swap(list, index1, index2);
           return list;
        }
        while(pointer1 != null && pointer2 != null){
            while(pointer1.next != null && pointer2 != null && pointer1.next.val <= pointer2.val){
                pointer1 = pointer1.next;
            }
            ListNode next = pointer1.next;
            pointer1.next = pointer2;
            if(pointer2.val < pointer1.val){
               int a = pointer1.val;
               pointer1.val = pointer2.val;
               pointer2.val = a;              
            }           
            pointer2 = pointer2.next;
            pointer1.next.next = next;
        }
        list.set(index2,null);
        return list;
    }
}


