package testTest;

import java.util.LinkedList;
import java.util.List;

public class FindTheWinnerOfTheCircularGame1823 {
    public int findTheWinner(int n, int k) {
        int valid = n;
        int[] arr = new int[n];
        List<Integer> list = new LinkedList<>();
        for(int i = 1;i <= n;i++){
          list.add(i);
        }
        int start = 0;
        while(list.size() > 1){
           int next = (start + k - 1) % valid;
           list.remove(next);
           valid--;
           start = next;
        }
        return list.get(0);
    }
}
