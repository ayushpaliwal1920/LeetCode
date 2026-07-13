class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int n = nums.length;
        int op = 0;
        for(int i = 1 ; i<n ; i++){
            if( nums[i] <= nums[i-1]){
                op++;
            }

            if(op > 1) return false;

            //  nums[i] hatanan 
            if (i > 1 && nums[i] <= nums[i - 2]) {
                nums[i] = nums[i - 1];
            }
            
        
        }

        

        return true;

    }
}