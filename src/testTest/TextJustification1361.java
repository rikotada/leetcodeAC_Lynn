package testTest;

import java.util.ArrayList;
import java.util.List;

public class TextJustification1361 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if(words == null || words.length == 0){
           return result;
        }
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(i < words.length){
            list.add(i);
            i = helper(i,words,maxWidth);
            
        }
        for(int j = 0; j < list.size() - 1;j++){
             int a = list.get(j);
             int b = list.get(j + 1);
             int num = b - a;
             if(num == 1){
                 StringBuilder str1 = new StringBuilder(words[a]);
                 while(str1.length() < maxWidth){
                     str1.append(" ");
                 }
                 result.add(str1.toString());
                 continue;
             }
             int total = 0;
             for(int m = a;m < b;m++){
                 total = total + words[m].length();
             }
             int spaceNum = (maxWidth - total) / (num - 1);          
             int left = maxWidth - total - (num - 1) * spaceNum;
             StringBuilder str = new StringBuilder("");
             StringBuilder space = new StringBuilder("");
             for(int n = 0;n < spaceNum;n++){
                 space.append(" ");
             }
             for(int k = a;k < b;k++){
                 if(str.length() > 0){
                    str.append(space);
                 }
                 str.append(words[k]);
                 if(left > 0){
                    str.append(" ");
                    left--;
                 }
             }
             result.add(str.toString());
        }
        int index = list.get(list.size() - 1);
        StringBuilder s = new StringBuilder("");
        for(int p = index;p < words.length;p++){
            if(s.length() > 0){
                s.append(" ");
            }
            s.append(words[p]);
        }
        result.add(addSpace(s,maxWidth));
        return result;

    }

    public int helper(int start,String[] words,int max){
        int length = 0;
        int i = start;
        while(i < words.length && length <= max){
            if(length > 0){
               length++;
               i++;
               if(i >= words.length){
                    break;
               }
            }
            length = length + words[i].length();
        }

        return i;
    }

    public String addSpace(StringBuilder s,int maxWidth){
        while(s.length() < maxWidth){
             s.append(" ");
        }
        return s.toString();
    }

    
}