package testTest;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class StickersToSpellWord691 {
    public int minStickers(String[] stickers, String target) {
         int len = stickers.length;
         int[] arr = new int[26];
         for(int i = 0;i < target.length();i++){
             char c = target.charAt(i);
             int index = c - 'a';
             arr[index]++;
         }
         Set<String> words = new HashSet<>();
         for(int i = 0;i < len;i++){
             String l =  getLeft(stickers[i],Arrays.copyOf(arr,26));
             if(l.length() > 0){
                words.add(l);
             }
         }
         int result = 0;
         Queue<String> q = new ArrayDeque<>();
         q.offer(target);
         Set<String> cutted = new HashSet<>();
         cutted.add(target);
         while(!q.isEmpty()){
             int size = q.size();
             for(int i = 0;i < size;i++){
                String s = q.poll();
                for(String piece:words){
                   String replaced = s;
                   for(int j = 0;j < piece.length();j++){
                       replaced = replaced.replaceFirst(""+piece.charAt(j),"");
                   }
                   if(replaced.equals("")){
                        return result + 1;
                   }
                   if(!cutted.contains(replaced)){
                       q.offer(replaced);
                       cutted.add(replaced);
                   }
                }
             }
             result++;
         }
         return -1;
    }


    public String getLeft(String word,int[] ch){
         PriorityQueue<Character> pq = new PriorityQueue<>();
         for(int i = 0;i < word.length();i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(ch[index] == 0){
               continue;
            }
            else{
                ch[index]--;
                pq.offer(c);
            }
         }
         StringBuilder sb = new StringBuilder();
         while(!pq.isEmpty()){
             sb.append(pq.poll());
         }
         return sb.toString();
    }
}
