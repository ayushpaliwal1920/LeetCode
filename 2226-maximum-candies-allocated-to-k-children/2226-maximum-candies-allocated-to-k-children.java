class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;

        int sum = 0;

        int maxCandy = 0;

        for( int num : candies){
            sum += num;
            maxCandy = Math.max(maxCandy , num);
        }
 
        int i = 1 ;
        int j = maxCandy;

        int ans  = 0;

        while( i <= j){
            int mid = i + (j-i)/2 ;
            long check = 0;
            for( int candy : candies){
                check += candy/mid;
            }

            if( check >= k){
                ans = mid;
                i = mid+1 ;
            }else{
                j = mid -1 ;
            }
        }

        return ans;

        
    }
}