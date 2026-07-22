class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length ;

        int totalSum = 0;

        for( int num : nums){
            totalSum += num;
        }

         if (totalSum % 2 != 0)
            return false;

        int target = totalSum/2 ;

        int[][] dp = new int[n][target+1];

        for( int[] row : dp){
            Arrays.fill(row , -1);
        }

        return helperMemo(nums , n-1 , target , dp);
    }

    public boolean helper(int[] nums , int idx , int target){
        if( target == 0) return true;

        if(idx == 0) return nums[0] == target;

        boolean notTake = helper(nums , idx - 1 , target);
        boolean take = false;

        if (nums[idx] <= target)
            take = helper(nums, idx - 1, target - nums[idx]);

        return take || notTake;
    }

    public boolean helperMemo(int[] nums , int idx, int target , int[][] dp){

        if( target == 0) return true;

        if(idx == 0) return nums[0] == target;

        if( dp[idx][target] != -1) return dp[idx][target] == 1;

        boolean notTake = helperMemo(nums , idx - 1 , target , dp);
        boolean take = false;

        if (nums[idx] <= target)
            take = helperMemo(nums, idx - 1, target - nums[idx] , dp);

        dp[idx][target] = (take || notTake)?1:0;

        return take || notTake;


    }
}