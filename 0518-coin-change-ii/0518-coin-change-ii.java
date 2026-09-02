class Solution {
    public int change(int amount, int[] coins) {
        int n= coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] rows : dp){
            Arrays.fill(rows , -1);
        }
        return helper(amount , coins , n-1 , dp);
    }
    public int helper(int amount , int[] arr , int n , int[][] dp){

        if(n == 0){
            if((amount % arr[0] ) == 0){
                return 1;
            }else{
                return 0;
            }
        }

        if(dp[n][amount] != -1) return dp[n][amount];

        int nottake = helper(amount , arr , n-1 , dp);
        int take = 0;
        if(arr[n] <= amount){
            take = helper(amount-arr[n] , arr , n , dp);
        }

        return dp[n][amount] = take + nottake;
    }
}
