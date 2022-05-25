package testTest;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation433 {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> visited = new HashSet<>();
        int len = bank.length;
        boolean has = false;
        for(int i = 0;i < len;i++){
            if(bank[i].equals(end)){
               has = true;
               break;
            }
        }
        if(!has){
           return -1;
        }
        visited.add(start);
        Queue<String> q = new ArrayDeque<>();
        q.offer(start);
        int step = 0;
        while(!q.isEmpty()){
             int size = q.size();
             for(int i = 0;i < size;i++){
                String s = q.poll();
                for(int j = 0;j < len;j++){
                   if(visited.contains(bank[j]) || !changable(s,bank[j])){
                       continue;
                   }
                   visited.add(bank[j]);
                   q.offer(bank[j]);
                   if(bank[j].equals(end)){
                       return ++step;
                   }
                }
             }
             step++;
        }
        return -1;
    }

    public boolean changable(String origin,String to){
        int diff = 0;
         for(int i = 0;i < 8;i++){
             char a = origin.charAt(i);
             char b = to.charAt(i);
             if(a != b){
                diff++;
             }
             if(diff > 1){
                return false;
             }
         }
         return diff == 1 ? true : false;
    }
}
