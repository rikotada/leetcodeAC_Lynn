package testTest;

public class MovingStonesUntilConsecutive1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int left = Math.min(Math.min(a,b),c);
        int right = Math.max(Math.max(a,b),c);
        int middle = 0;
        if(left != a && right != a){
            middle = a;
        }
        else if(left != b && right != b){
            middle = b;
        }
        else{
            middle = c;
        }

        int min = 0;
        if(middle > left + 1){
           min++;
        }
        if(right > middle + 1){
           min++;
        }
        if(right - middle == 2 || middle - left == 2){
           min = 1;
        }
        int max = 0;
        max += right - middle - 1;
        max += middle - left - 1;
        int[] result = {min,max};
        return result;

    }
}
