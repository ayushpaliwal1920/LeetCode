class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalsum = 0;
        int n = nums.length;

        for(int num : nums){
            totalsum += num;
        }

        if(((totalsum - target) < 0) || (totalsum-target)%2 != 0) return 0;
        int[][] dp = new int[n][totalsum-target +1];

        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        
        int d = (totalsum - target)/2;
        return helper(nums , n-1 , d , dp);
    }

    public int helper(int[] arr  , int n , int target , int[][] dp){
        if(n == 0){
            if(target == 0 && arr[0] == 0) return 2;
            else if( target == 0 || target == arr[0]) return 1; 
            else return 0;
        }
        if(dp[n][target] != -1) return dp[n][target];

        int notpick = helper(arr , n-1 , target , dp);
        int pick = 0;

        if(arr[n] <= target){
            pick = helper(arr , n-1 , target- arr[n] , dp);
        }
        return dp[n][target] = pick + notpick;

    }
}