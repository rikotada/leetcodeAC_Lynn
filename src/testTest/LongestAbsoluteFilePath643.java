package testTest;

public class LongestAbsoluteFilePath643 {
    /**
     * @param input: an abstract file system
     * @return: return the length of the longest absolute path to file
     */
    public int lengthLongestPath(String input) {
        // write your code here
        if(input.length() == 0 ||!input.contains(".")){
            return 0;
        }
        int result = 0;
        String[] ss = input.split("\\n");
        int n = ss.length;
        System.out.println(n);
        int[] layer = new int[n];

        for(int i = 0;i < n;i++){
            int l = ss[i].lastIndexOf("\t") + 1;
            layer[i] = l;
            if(l > 0){
               ss[i] = ss[i].substring(l);
            }           
        }
        
        for(int m = 0;m <n;m++){
           int la = layer[m];
           if(la > 0){
               int current = m;
               while(layer[current] >= la){
                    current--;
               }
               ss[m] = ss[current]+"_"+ss[m];
           }
        }
        for(String str:ss){
            if(str.contains(".")){
               result = Math.max(result,str.length());
            }
            
        }
        return result;

    }
}
