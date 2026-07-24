class Solution {
    public int lastStoneWeightII(int[] nums) {
        int n = nums.length;

        int totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }

        return helper(nums , totalSum);
    }

    public int helper(int[] nums , int target){
        int n = nums.length;

        boolean[][] dp = new boolean[n][target + 1];

        // Base case ; 

        for(int i = 0 ; i< n ; i++){
            dp[i][0] = true;
        }

        if(nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for(int i = 1 ; i< n ; i++){
            for(int j = 1 ; j <= target; j++){
                boolean pick = false;
                if (nums[i] <= j)
                    pick = dp[i - 1][j - nums[i]];

                boolean notPick = dp[i-1][j];

                dp[i][j] = pick || notPick;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int s1 = 0; s1 <= target / 2; s1++) {

            if (dp[n - 1][s1]) {

                min = Math.min(min, target - 2 * s1);
            }
        }
        return min;

    }

}