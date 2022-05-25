package testTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SmallestStringWithSwaps1202 {
    String result = null;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
         int len = pairs.size();
         Union u = new Union(s.length());

         for(int i = 0;i < len;i++){
             int x0 = pairs.get(i).get(0);
             int x1 = pairs.get(i).get(1);
             u.join(x0,x1);
         }

         Map<Integer,PriorityQueue<Character>> pqmap = new HashMap<>();
         for(int i = 0;i < s.length();i++){
             int root = u.findRoot(i);
             if(!pqmap.keySet().contains(root)){
                 PriorityQueue<Character> pq = new PriorityQueue<Character>();
                 pq.offer(s.charAt(i));
                 pqmap.put(root,pq);
             }
             else{
                  PriorityQueue<Character> pq = pqmap.get(root);
                  pq.offer(s.charAt(i));
             }
         }

         StringBuffer sb = new StringBuffer();
         for(int i = 0; i < s.length();i++){
             sb.append(pqmap.get(u.findRoot(i)).poll());
         }
         return sb.toString();
    }

    class Union{
        Map<Integer,Integer> map = new HashMap<>();
        public Union(int n){
           for(int i = 0;i < n;i++){
              map.put(i,i);
           }
        }

        public int findRoot(int i){
           int root = map.get(i);
           int key = i;
           while(root != i){
               i = root;
               root = map.get(i);
           }
           map.put(key,root);
           return root;
        }

        public void join(int a,int b){

            int rootA = findRoot(a);
            int rootB = findRoot(b);

            if(rootA != rootB){
                map.put(Math.max(rootA,rootB),Math.min(rootA,rootB));
            }
            
        }
    }

   

    
}
