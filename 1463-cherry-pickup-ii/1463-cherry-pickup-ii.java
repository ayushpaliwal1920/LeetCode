class Solution {
    public int cherryPickup(int[][] grid) {
        // return helper( 0 , 0 , grid[0].length-1 , grid);

        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];

        for (int[][] g : dp) {
            for (int[] row : g) {
                Arrays.fill(row, -1);
            }
        }

        return helperMemo(0 , 0 , grid[0].length -1 , grid , dp);

    }

    public static int helper(int i , int j1 , int j2 , int[][] grid){ //  TC = 3^n
        int n = grid.length;
        int m = grid[0].length;

        // base case (boundary based)

        if( j1 < 0 || j1 >= m || j2 < 0 || j2 >= m){
            return (int) -1e8;
        }

        // base case (destination) 

        if( i == n-1){
            if(j1 == j2) return grid[i][j1];
            else{
               return  grid[i][j1] + grid[i][j2];
            }
        }

        // exploration of all paths : 

        int max = (int) -1e8;

        for( int dj1 = -1 ; dj1 <= 1 ; dj1++){  // dj refers to the change in the columns or paths where a robot can move
            for(int dj2 = -1 ; dj2 <= 1 ; dj2++){
                int value ;

                if( j1 == j2){
                    value = grid[i][j1] + helper(i+1 , j1 + dj1 , j2 + dj2 , grid);
                }else{
                    value = grid[i][j1] + grid[i][j2] + helper(i+1 , j1 + dj1 , j2 + dj2 , grid);
                }
                max = Math.max(value , max);

            }
        }

        return max;
    }

    // Memo 

    public static int helperMemo(int i , int j1 , int j2 , int[][] grid , int[][][] dp){
        int n = grid.length;
        int m = grid[0].length;

        // base case (boundary based)

        if( j1 < 0 || j1 >= m || j2 < 0 || j2 >= m){
            return (int) -1e8;
        }

        // base case (destination) 

        if( i == n-1){
            if(j1 == j2) return grid[i][j1];
            else{
               return  grid[i][j1] + grid[i][j2];
            }
        }

        if( dp[i][j1][j2] != -1) return dp[i][j1][j2];

        // exploration of all paths : 

        int max = (int) -1e8;

        for( int dj1 = -1 ; dj1 <= 1 ; dj1++){  // dj refers to the change in the columns or paths where a robot can move
            for(int dj2 = -1 ; dj2 <= 1 ; dj2++){
                int value ;

                if( j1 == j2){
                    value = grid[i][j1] + helperMemo(i+1 , j1 + dj1 , j2 + dj2 , grid, dp);
                }else{
                    value = grid[i][j1] + grid[i][j2] + helperMemo(i+1 , j1 + dj1 , j2 + dj2 , grid , dp);
                }
                max = Math.max(value , max);

            }
        }

        return dp[i][j1][j2] = max;
    }
}