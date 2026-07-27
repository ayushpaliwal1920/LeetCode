class Solution {
    public int findMinFibonacciNumbers(int k) {

        List<Integer> fibarr = fibo(k);
        int n = fibarr.size();

        // int[][] dp = new int[n][k+1];

        // for(int[] row : dp){
        //     Arrays.fill(row , -1);
        // }

        // return helper(n-1 , k , fibarr , dp);

        int i = n -1 ;
        int ans = 0;

        // take largest one and subtract it with k them repeat

        while( k > 0){
            if(fibarr.get(i) <= k){
                k = k - fibarr.get(i);
                ans++;
            }else{
                i--;
            }
        
        }

        return ans;


        
    }

    public List<Integer> fibo(int k){

        ArrayList<Integer> fibarr = new ArrayList<>();

        fibarr.add(1);
        fibarr.add(1);

        while (true) {
            int next = fibarr.get(fibarr.size() - 1) + fibarr.get(fibarr.size() - 2);

            if (next > k)
                break;

            fibarr.add(next);
        }

        return fibarr;
    }

    // public int helper(int n , int target , List<Integer> fibarr , int[][] dp){
    //     if(n < 0) return (int) 1e9;

    //     if(target == 0){ return 0 ;}

    //     if(dp[n][target] != -1) return dp[n][target];

    //     int notpick = helper(n - 1, target, fibarr , dp);
    //     int pick = (int) 1e9;

    //     if(fibarr.get(n) <= target){
    //      pick = 1 + helper(n-1 , target - fibarr.get(n) , fibarr , dp);
    //     }

    //     return dp[n][target] = Math.min(pick , notpick);
    // }


}