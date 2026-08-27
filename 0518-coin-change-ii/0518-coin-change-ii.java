class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // int[][] dp = new int[n][amount+1];

        // for(int[] row : dp){
        //     Arrays.fill(row , -1);
        // }
        return helpertabulation(amount , coins);
    }
    public int helper(int amount , int[] arr , int n , int[][] dp){
        if(n == 0){
            if(amount % arr[0] == 0) return 1;
            else return 0;
        }

        if(dp[n][amount] != -1) return dp[n][amount];

        int notpick = helper(amount , arr , n-1 , dp);
        int pick = 0;
        if(arr[n] <= amount){
            pick = helper(amount - arr[n] , arr , n , dp);
        }
        return  dp[n][amount] = pick + notpick;
    }

    public int helpertabulation(int target , int[] arr){
        int n = arr.length;

        int[][] dp = new int[n][target+1];

        for(int t = 0 ; t <= target ; t++){
            dp[0][t] = (t % arr[0] == 0) ? 1  : 0;
        }

        for(int i = 1 ; i< n ; i++){
            for(int t = 0 ; t <= target ; t++){
                int notpick = dp[i-1][t];
                int pick = 0;
                if(arr[i] <= t){
                    pick = dp[i][t - arr[i]];
                }

                dp[i][t] = pick + notpick;
            }
        }

        return dp[n-1][target];

    }


}