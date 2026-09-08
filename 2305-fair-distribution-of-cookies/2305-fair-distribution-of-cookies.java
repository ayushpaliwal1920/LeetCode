class Solution {
    int ans = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int[] arr = new int[k];
        solve(cookies , k , arr , 0);
        return ans;
    }
    public void solve(int[] cookies , int k , int[] arr , int idx){

        if( idx == cookies.length){
            int max = 0;
            for(int num : arr){
                max = Math.max(num , max);
            }
            ans = Math.min(max , ans);
            return;
        }

        for(int j = 0 ; j < k ; j++){
            arr[j] += cookies[idx];
            solve(cookies , k , arr , idx+1);
            arr[j] -= cookies[idx];
        }
    }
}