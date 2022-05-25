package testTest;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses426 {
    /**
     * @param s: the IP string
     * @return: All possible valid IP addresses
     */
    public List<String> restoreIpAddresses(String s) {
        // write your code here
        List<String> result = new ArrayList<>();
        if(s == null || s.length() > 12 || s.length() < 4){
           return result;
        }
        dfs(s,0,0,"",result);
        return result;
    }

    public void dfs(String s,int startIndex,int pointNum,String current,List<String> result){
        if(pointNum == 4){
           if(startIndex == s.length()){
              result.add(new String(current.substring(0, current.length() - 1)));
           }
           return;
        }
        // String a = new String(current);
        for(int i = 1;i < 4;i++){
            if(startIndex + i > s.length() ){
                continue;
            }
            String maybeNum = s.substring(startIndex,startIndex + i);
            if(!isValid(maybeNum)){
                continue;
            }
            dfs(s,startIndex + i,pointNum + 1,current + maybeNum + ".",result);
        }
        return;
    }

    public boolean isValid(String s){
        Integer a = Integer.parseInt(s);
        if(a > 255){
            return false;
        }
        if(a < 10 && s.length() >= 2){
            return false;
        }
        if(a < 100 && s.length() >= 3){
           return false;
        }
        return true;
    }
}
