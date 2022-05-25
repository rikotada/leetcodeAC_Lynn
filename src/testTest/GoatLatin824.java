package testTest;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin824 {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        int len = words.length;
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        String ss = words[0];
        if(set.contains(ss.charAt(0)) || ss.length() == 1){
            sb.append(ss);          
        }
        else{
            sb.append(ss.substring(1));
            sb.append(ss.charAt(0));
        }
        sb.append("maa");
        for(int i = 1;i < len;i++){
            String s = words[i];
            sb.append(" ");
            if(set.contains(s.charAt(0)) || s.length() == 1){
               sb.append(s);
            }
            else{
                sb.append(s.substring(1));
                sb.append(s.charAt(0));
            }
            sb.append("ma");
            for(int j = 0;j <= i;j++){
               sb.append("a");
            }
        }

        return sb.toString();

    }
}
