class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][k+1];
    
      for(int[][] mat : dp){
        for(int[] row : mat){
            Arrays.fill(row , -2);
        }
        }

        return helper(n-1 , m-1 , grid , k , dp);
    }
    public int helper(int i , int j , int[][] grid , int k , int[][][] dp){
    
        if(i < 0 || j < 0 || k < 0 ) return -1;

        if( i == 0 && j == 0){
            int cost = grid[0][0] ==0 ? 0 : 1;
            if(k >= cost ){
                return grid[i][j];
            }else{
                return -1;
            }
        }

        if(dp[i][j][k] != -2) return dp[i][j][k];

        int cost = grid[i][j] == 0 ? 0 : 1;

        int up = helper(i - 1, j, grid, k - cost, dp);
        int left = helper(i, j - 1, grid, k - cost, dp);
            

        if( up == -1 && left == -1){
             return dp[i][j][k] = -1;
        }


        return dp[i][j][k] = grid[i][j] + Math.max(up ,left);

    }

    // public int helperTabulation(int[][] grid , int k){
    //     int n = grid.length;
    //     int m = grid[0].length;

    //     int[][][] dp = new
    // }
}