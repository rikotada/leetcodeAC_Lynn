package testTest;

public class TypingPractising299 {
    /**
     * @param s: A string
     * @return: A string
     */
    public String getTextcontent(String s) {
        // write your code here.
        if(s == null || s.length() == 0){
           return s;
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < len;i++){
           if(s.charAt(i) == '<'){
               if(sb.length() > 0){
                  sb.deleteCharAt(sb.length() - 1);
               }
           }
           else{
              sb.append(s.charAt(i));
           }
           
        }
        return sb.toString();
    }
}
