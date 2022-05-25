package testTest;

public class DIStringMatch942 {
    public int[] diStringMatch(String s) {
        int len = s.length();
        int small = 0;
        int large = len;
        int[] result = new int[len + 1];
        for(int i = 0;i < len;i++){
            if(s.charAt(i) == 'I'){
                result[i] = small;
                small++;
            }
            else{
                result[i] = large;
                large--;
            }
        }
        result[len] = small;
        return result;
    }
}
