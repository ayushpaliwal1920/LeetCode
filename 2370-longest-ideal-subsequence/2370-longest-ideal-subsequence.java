class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][27];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        return helper(s , k , n-1 , 26 , dp);
    }

    public int helper(String s , int k , int n , int ch , int[][] dp){

        if(n < 0){
            return 0;
        }

        if(dp[n][ch] != -1) return dp[n][ch];

        int notPick = helper(s , k , n-1 , ch , dp);
        int pick = 0;
        if(ch == 26 || Math.abs((s.charAt(n) - 'a') - ch) <= k){
            pick = 1 + helper(s , k , n-1 , s.charAt(n) - 'a' , dp);
        }

        return dp[n][ch] = Math.max(pick , notPick);
    }
}