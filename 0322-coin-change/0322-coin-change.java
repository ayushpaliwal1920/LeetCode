class Solution {
    public int coinChange(int[] coins, int amount) {
       int n = coins.length;

    //    int[][] dp = new int[n][amount+1];    
    //    for(int[] row : dp){
    //      Arrays.fill(row , -1);
    //    }

       int ans =  helperTabulation(coins , n , amount);

       return ans >= 100000 ? -1 : ans;
    }
    public int helper(int[] coins , int t , int n , int[][] dp){
        // Base case :
        if(n==0){
            if(t % coins[n] == 0){
                return t/coins[n];
            }else{
                return 100000;
            }
        }

        // dp : 

        if(dp[n][t] != -1){
            return dp[n][t];
        }
        
        //  all ways :

        int notTake = helper(coins , t , n-1 , dp); // n = index , t = target or amount
        int take = 100000;

        if(coins[n] <= t){
         take = 1 + helper(coins , t-coins[n] , n , dp);  // for multiple use index remains the same until the condition is not failed.
        }        

        // Min :

        return dp[n][t] = Math.min(take , notTake);

    }

    public int helperTabulation(int[] coins ,int n ,int t ){
        int[][] dp = new int[n][t+1];

        for(int i = 0 ; i <= t ; i++){
            if(i % coins[0] == 0){
                dp[0][i] = i/coins[0];
            }else{
                dp[0][i] = 100000;
            }
        }

        for(int i = 1  ; i < n ; i++){
            for(int j = 0 ; j <= t ; j++){
                int nottake = dp[i-1][j];
                int take = 100000;
                if(coins[i] <= j){
                    take = 1 + dp[i][j - coins[i]];
                }

                dp[i][j] = Math.min(take , nottake);
            }
        }

        return dp[n-1][t];
    }
}
