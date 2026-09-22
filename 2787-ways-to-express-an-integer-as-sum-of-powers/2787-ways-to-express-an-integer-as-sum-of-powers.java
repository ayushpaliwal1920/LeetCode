class Solution {

    int bsdk = (int)1e9 + 7;

    public int numberOfWays(int n, int x) {
        int[][] dp = new int[n+1][n+1];

        for(int[] row : dp){
            Arrays.fill(row , -1);
        }

        return helper(n , x , 1 , dp);
    }

    public int helper(int n , int x , int num , int[][] dp){
        if( n == 0){
            return 1;
        }

        if(num > n){
            return 0;
        }

        if(dp[n][num] != -1){
            return dp[n][num];
        }

        long power = (long) Math.pow(num , x);

        if(power > n){
            return 0;
        }

        int pick = helper((int)(n-power) , x , num+1 , dp);

        int notpick = helper(n, x, num+1 ,dp);

        return dp[n][num] = (int)(pick+notpick) % bsdk ;
    }
}