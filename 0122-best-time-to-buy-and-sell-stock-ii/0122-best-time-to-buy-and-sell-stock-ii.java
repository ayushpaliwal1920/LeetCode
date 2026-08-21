class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];

        Arrays.fill(dp , -1);

        return helper(prices , n-1 , dp);
    }
    public int helper(int[] prices , int n , int[] dp){
        if(n == 0){
            return 0;
        }

        if(dp[n] != -1) return dp[n];

        if(prices[n] <= prices[n-1]){
            return helper(prices , n-1 , dp);
        }

        return dp[n] = (prices[n] - prices[n-1]) + helper(prices , n-1 , dp);
    }
}