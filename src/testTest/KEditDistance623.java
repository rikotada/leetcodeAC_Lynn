package testTest;

import java.util.LinkedList;
import java.util.List;

public class KEditDistance623 {
    /**
     * @param words: a set of stirngs
     * @param target: a target string
     * @param k: An integer
     * @return: output all the strings that meet the requirements
       https://blog.csdn.net/sdkghsrkghkrrg/article/details/118179078
     */
    int val;
    List<String> result = new LinkedList<>();
    int targetLen;
    char[] targetArr;
    public List<String> kDistance(String[] words, String target, int k) {
        // write your code here       
        if(words == null || words.length == 0){
             return result;
        }
        val = k;
        targetLen = target.length();
        targetArr = target.toCharArray();
        Trie root = new Trie();
        for(int s = 0; s < words.length;s++){
            root.insertWord(words[s]);
        }
        int[] first = new int[targetLen + 1];
        for(int i = 0;i <= targetLen;i++){
           first[i] = i;
        }
        dfs(root,first);
        return result;
    }

    public void dfs(Trie node,int[] dp){

        if(node.isWord && dp[targetLen] <= val){
            result.add(node.word);
        }
        int[] newdp = new int[targetLen + 1];
        newdp[0] = dp[0] + 1;
        for(int i = 0;i < 26;i++){
            
            Trie subNode = node.sons[i];
            if(subNode == null){
               continue;
            }
            
            for(int m = 1;m <= targetLen;m++){
                newdp[m] = Math.min(Math.min(newdp[m - 1],dp[m]),dp[m - 1])+1;
                if(i == targetArr[m - 1] - 'a'){
                    newdp[m] = Math.min(newdp[m],dp[m - 1]);
                }
            }
            dfs(subNode,newdp);
        }
    }

    class Trie{
        boolean isWord;
        String word;
        Trie[] sons = new Trie[26];

        public void insertWord(String s){
            char[] arr = s.toCharArray();
            int n = s.length();
            Trie node = this;
            for(int i = 0;i < n;i++){
               int index = arr[i] - 'a';
               if(node.sons[index] == null){
                   node.sons[index] = new Trie();
               }
               node = node.sons[index];
            }

            node.isWord = true;
            node.word = s;
        }


    }
}
