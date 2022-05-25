package testTest;

public class NumberOfWaysToBuyPensAndPencils2240 {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
          int expensive = Math.max(cost1,cost2);
          int cheap = Math.min(cost1,cost2);
          int n = total / expensive;
          long result = 0;
          for(int i = 0;i <= n;i++){
               result += (total - i * expensive) / cheap + 1;
          }
          return result;
    }
}
