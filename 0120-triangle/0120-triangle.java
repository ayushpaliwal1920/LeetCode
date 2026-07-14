class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();

        int[][] dp = new int[m][n];

        for(int[] row : dp){
            Arrays.fill(row , Integer.MAX_VALUE);
        }

        return minMemo(0 , 0 ,triangle , dp);
    }
    public int minMemo(int i ,int j , List<List<Integer>> arr , int[][] dp){
      
            int n = arr.size();

            if (i == n - 1) {
                return arr.get(i).get(j);
            }

            if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

            int down = arr.get(i).get(j) + minMemo(i + 1, j, arr , dp);
            int diag = arr.get(i).get(j) + minMemo(i + 1, j + 1, arr , dp);

            return dp[i][j] = Math.min(down, diag);
    }

    // Tabulaton :

    
}