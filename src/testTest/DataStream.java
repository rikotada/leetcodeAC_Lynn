package testTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
@SuppressWarnings("all")
public class DataStream {
    
    
    public LinkedHashSet set;
    public HashMap map;
    public DataStream(){
        // do intialization if necessary
        set = new LinkedHashSet();
        map = new HashMap();
    }
    /**
     * @param num: next number in stream
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        set.add(num);
        if(map.keySet().contains(num)){
           map.put(num,false);
        }
        else{
           map.put(num, true);
        }
        
    }

    /**
     * @return: the first unique number in stream
     */
    
	public int firstUnique() {
        // write your code here
        Iterator it = set.iterator();
        while(it.hasNext()){
            int i = (int)it.next();
            if((boolean)map.get(i)){
               return i;
            }
        }
        return 0;
    }
}
