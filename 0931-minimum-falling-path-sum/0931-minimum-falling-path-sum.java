class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int min = Integer.MAX_VALUE;

        int[][] dp = new int[n][m];

        for(int[] row : dp){
            Arrays.fill(row , Integer.MAX_VALUE);
        }

        for(int j = 0 ; j < m ; j++){
            min = Math.min(min , helperMemo(n-1 , j , matrix , dp));
        }

        return min;
    }

    // Recursion : 

    public int helper1(int i , int j , int[][] matrix){
        int m = matrix[0].length;

        if( j < 0 || j >= m )  return (int)1e9;
        if( i == 0 ) return matrix[i][j];

        int up = matrix[i][j] + helper1(i-1 , j , matrix);
        int upleft = matrix[i][j] + helper1(i-1 , j-1 , matrix);
        int upright = matrix[i][j] + helper1(i-1 ,j+1 , matrix);

        return Math.min(up , Math.min(upleft , upright));
    }

    // Memoization : 

        public int helperMemo(int i , int j , int[][] matrix ,int[][] dp){
        int m = matrix[0].length;

        if( j < 0 || j >= m )  return (int)1e9;
        if( i == 0 ) return matrix[i][j];

        if( dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int up = matrix[i][j] + helperMemo(i-1 , j , matrix , dp);
        int upleft = matrix[i][j] + helperMemo(i-1 , j-1 , matrix , dp);
        int upright = matrix[i][j] + helperMemo(i-1 ,j+1 , matrix , dp);

        return dp[i][j] = Math.min(up , Math.min(upleft , upright));
    }


}