class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;

        //  creating prefix array :

        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for(int i = 1; i< n ; i++){
            prefix[i] = nums[i] + prefix[i-1];
        }
        // creating avg array

        int[] avg = new int[n];

        

        for(int i = 0 ; i< n ; i++){
            if( i-k < 0){
                avg[i] = -1 ;
                continue;
            }else if( i+k > n-1){
                avg[i] = -1;
                continue;
            }else{
                if( i-k-1 >=0 ){
                avg[i] = (int) ((prefix[i+k] - prefix[(i-k)-1])/((i+k) - (i-k) + 1));
                }else{
                    avg[i] = (int) (prefix[i+k]/((i+k) - (i-k) + 1));
                }
            }
        }
        return avg;


    }
}