package testTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SimiliarSentence856 {
    public boolean is(String[] words1, String[] words2, List<List<String>> lists) {
    	if(words1.length != words2.length) {
    		return false;
    	}
    	if(words1 == null && words2 == null) {
    		return true;
    	}
    	if(words1 == null || words2 == null) {
    		return false;
    	}
    	Map<String,HashSet<String>> map = new HashMap<>();
    	for(int i = 0;i < lists.size();i++) {
    		String word1 = lists.get(i).get(0);
    		String word2 = lists.get(i).get(1);
    		map.putIfAbsent(word1, new HashSet<>());
    		map.getOrDefault(word1, new HashSet<>()).add(word2);	
    	}
    	for(int m = 0;m<words1.length;m++) {
    		boolean flag1 = map.get(words1[m]) == null || !map.get(words1[m]).contains(words2[m]);
    		boolean flag2 = map.get(words2[m]) == null || !map.get(words2[m]).contains(words1[m]);
    		if(flag1 && flag2) {
    			return false;
    		}
    	}
    	return true;
    }
}
