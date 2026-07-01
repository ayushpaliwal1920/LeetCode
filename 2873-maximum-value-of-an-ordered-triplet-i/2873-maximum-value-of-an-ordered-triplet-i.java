class Solution {
    public long maximumTripletValue(int[] nums) {
        long max = 0;
        int n = nums.length;
        for(int i = 0 ;i< n-1 ; i++){
            for(int j = i+1 ; j < n ; j++){
                for(int k = j+1 ; k < n ; k++){
                    long temp = (long)(nums[i] - nums[j]) * nums[k];

                    if( temp < 0) temp = 0;

                    max = Math.max(max , temp );
                }
            }
        }
        return max;
    }
}