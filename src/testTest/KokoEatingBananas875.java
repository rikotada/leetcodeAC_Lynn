package testTest;

class KokoEatingBananas875 {
    public int minEatingSpeed(int[] piles, int h) {
         if(piles == null || piles.length == 0){
            return -1;
         }
         int max = 0;
         int len = piles.length;
         for(int i = 0;i < len;i++){
            max = Math.max(max,piles[i]);
         }         

         int min = 1;
         while(min + 1 < max){
            long mid = getTime(piles,(max - min) / 2 + min,len);
            if(mid <= h){
                max = (max - min) / 2 + min;
            }
            else{
                min = (max - min) / 2 + min;
            }
         }
         if(getTime(piles,min,len) > h){
             return max;
         }
         return min;
    }

    public long getTime(int[] piles,int speed,int len){
        long sum = 0;
        for(int k = 0;k < len;k++){
            int t = piles[k] / speed;
            if(piles[k] % speed != 0){
                t++;
            }
            sum += t;
        }
        return sum;
    }
}
