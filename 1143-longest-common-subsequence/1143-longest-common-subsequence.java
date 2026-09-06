class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];

        for(int[] r : dp ){
            Arrays.fill(r, -1);
        }

        return helperMemo1(text1, text2, n1 - 1, n2 - 1 , dp);
    }

    public int helper1(String s1 , String s2 , int n1 , int n2){
        if( n1 < 0 || n2 < 0){
            return 0;
        }

        if(s1.charAt(n1) == s2.charAt(n2)){
            return 1+helper1(s1 , s2 , n1-1 , n2-1);
        }

        return Math.max(helper1(s1 , s2 , n1-1 , n2) , helper1(s1 , s2 ,n1 , n2-1));
    }

        // Memoization :

    public static int helperMemo1(String s1, String s2, int n1, int n2 , int[][] dp) {
        if (n1 < 0 || n2 < 0) {
            return 0;
        }


        if(dp[n1][n2] != -1){
            return  dp[n1][n2];
        }


        if (s1.charAt(n1) == s2.charAt(n2)) {
            return 1 + helperMemo1(s1, s2, n1 - 1, n2 - 1 , dp);
        }

        return dp[n1][n2] = Math.max(helperMemo1(s1, s2, n1 - 1, n2 , dp), helperMemo1(s1, s2, n1, n2 - 1 , dp));
    }

}