package testTest;

public class OneAwayLCCI {
    public boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        if(Math.abs(len1 - len2) > 1){
             return false;
        }
        boolean result = len1 >= len2 ? check(second,first) : check(first,second);
        return result;
        
    }

    public boolean check(String shorter,String longer){
        int lenl = longer.length();
        int lens = shorter.length();
        int j = 0;
        int i = 0;
        int diff = 0;
        if(lenl == 1 && lens == 1){
            return true;
        }
        while(i < lenl && j < lens){
            if(longer.charAt(i) == shorter.charAt(j)){
                i++;
                j++;
            }
            else if(lenl == lens){
                i++;
                j++;
                diff++;
            }
            else{
                i++;
                diff++;
            }
            if(diff > 1){
                return false;
            }
        }
        return true;
    }



}
