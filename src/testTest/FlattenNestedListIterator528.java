package testTest;

import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

interface NestedInteger {
	 
	      // @return true if this NestedInteger holds a single integer,
	     // rather than a nested list.
	      public boolean isInteger();
	 
	      // @return the single integer that this NestedInteger holds,
	      // if it holds a single integer
	      // Return null if this NestedInteger holds a nested list
	      public Integer getInteger();
	 
	      // @return the nested list that this NestedInteger holds,
	     // if it holds a nested list
	     // Return null if this NestedInteger holds a single integer
	      public List<NestedInteger> getList();
}


public class FlattenNestedListIterator528 implements Iterator<Integer> {
    List<Integer> result = new ArrayList<>();
    Queue<NestedInteger> q = new ArrayDeque<>();
    int pointer = 0;
    
    
 


    public FlattenNestedListIterator528(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        for(NestedInteger ni : nestedList){
           q.add(ni);
        }
        int size1 = q.size();
        int size2 = 0;
        while(size1 != size2){
            size1 = q.size();
            int i = size1;
            while(i >0){
                NestedInteger nest = q.poll();
                if(nest.isInteger()){
                   q.add(nest);
                }
                else{
                   List<NestedInteger> list = nest.getList();
                   for(NestedInteger nested: list){
                      q.add(nested);
                   }
                }
                i--;
            }
            size2 = q.size();
            
        }
        while(!q.isEmpty()){
           result.add(q.poll().getInteger());
        }
       
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        return result.get(pointer++);

    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        return pointer < result.size() ? true :false;
    }

    @Override
    public void remove() {}
}
