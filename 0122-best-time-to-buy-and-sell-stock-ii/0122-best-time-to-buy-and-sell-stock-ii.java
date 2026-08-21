class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        return helper(prices , n-1);
    }
    public int helper(int[] prices , int n){
        if(n == 0){
            return 0;
        }

        if(prices[n] <= prices[n-1]){
            return helper(prices , n-1);
        }

        return (prices[n] - prices[n-1]) + helper(prices , n-1);
    }
}