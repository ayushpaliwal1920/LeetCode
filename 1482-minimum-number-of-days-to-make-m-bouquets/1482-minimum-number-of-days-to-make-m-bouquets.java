class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i : bloomDay){
            max = Math.max(i , max);
            min = Math.min(i , min);
        }
        
        int i = min; 
        int j = max;

        if((long) m*k > n) return -1;

        int ans = 0;

        while( i <= j){
            int mid = i + (j-i)/2 ;
            
            if(isPossible(bloomDay , mid , m , k)){
                ans = mid;
                j = mid-1;
            }else{
                i = mid+1;
            }
        }

        return ans;

    }

    public static boolean isPossible(int[] bloomDay, int day, int m, int k) {

            int bouquets = 0;
            int count = 0;

            for (int flower : bloomDay) {

                if (flower <= day) {
                    count++;
                } else {
                    bouquets += count / k;
                    count = 0;
                }
            }

            bouquets += count / k;

            return bouquets >= m;
    }
}