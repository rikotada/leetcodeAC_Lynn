package testTest;

public class DeleteColumnsToMakeSorted944 {
    public int minDeletionSize(String[] strs) {
        int len = strs.length;
        int n = strs[0].length();
        int result = 0;
        String[] arr = new String[n];
        for(int i = 0;i < n;i++){
           for(int j = 0;j < len - 1;j++){
              if(strs[j].charAt(i) - strs[j + 1].charAt(i) > 0){
                result++;
                break;
              }
           }
        }
        return result;
    }
}
