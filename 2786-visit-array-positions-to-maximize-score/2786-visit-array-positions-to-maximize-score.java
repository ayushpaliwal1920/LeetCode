class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[][] dp = new long[n][2];

        for(long[] r : dp){
            Arrays.fill(r , Long.MIN_VALUE);
        }

        return nums[0] + helper(nums , x , 1 , nums[0] % 2, dp);
    }

    public long helper(int[] nums , int x, int n , int prev , long[][] dp){

        if(n == nums.length){
            return 0;
        }

        if(dp[n][prev] !=  Long.MIN_VALUE){
            return dp[n][prev];
        }
        
        long notpick = helper(nums ,  x , n+1 , prev , dp);
   

           int currParity = nums[n] % 2;

            long pick;

            if (prev == currParity) {
                pick = nums[n]
                        + helper(nums, x, n + 1, currParity, dp);
            } else {
                pick = nums[n] - x
                        + helper(nums, x, n + 1, currParity, dp);
            }

        return dp[n][prev] = Math.max(pick , notpick);

    } 
}