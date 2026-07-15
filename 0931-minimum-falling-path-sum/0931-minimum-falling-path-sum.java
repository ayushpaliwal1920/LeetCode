class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // int min = Integer.MAX_VALUE;

        // int[][] dp = new int[n][m];

        // for(int[] row : dp){
        //     Arrays.fill(row , Integer.MAX_VALUE);
        // }

        // for(int j = 0 ; j < m ; j++){
        //     min = Math.min(min , helperMemo(n-1 , j , matrix , dp));
        // }

        return helperTabulation1(matrix);
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

    // Tabulation : 

    public static int helperTabulation1(int[][] matrix) {


        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        // Base case :

        for (int c = 0; c < m; c++) {
            dp[0][c] = matrix[0][c];
        }

        for (int r = 1; r < n; r++) {
            for (int c = 0; c < m; c++) {
                int upleft = (int) 1e9;
                int upright = (int) 1e9;
                int up = matrix[r][c] + dp[r - 1][c];
                if (c > 0) {
                    upleft = matrix[r][c] + dp[r - 1][c - 1];
                }
                if (c < m - 1) {
                    upright = matrix[r][c] + dp[r - 1][c + 1];
                }

                dp[r][c] = Math.min(up, Math.min(upleft, upright));
            }
        }

        int min = Integer.MAX_VALUE;

        for (int c = 0; c < m; c++) {
            min = Math.min(min, dp[n - 1][c]);
        }

        return min;
    }



}