class Solution {
    public int findMiddleIndex(int[] nums) {
        int total = 0;  
        int n = nums.length;
        
        for(int num : nums){
            total += num;
        }

        int lefthalf = 0;

        for(int i = 0 ; i<n ; i++){
            int right = total - (lefthalf + nums[i]);
            if(lefthalf == right){
                return i;
            }
            lefthalf += nums[i];
        }

        return -1;

    }
}