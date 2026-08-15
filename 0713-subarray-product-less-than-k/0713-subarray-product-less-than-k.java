class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
      int n = nums.length;
      int count = 0;

      for(int i = 0 ; i< n ; i++){
          int temp = 1;
          for(int j = i ; j< n ; j++){
             temp *= nums[j];
             if(temp < k){
                count++;
             }else{
                break;
             }
          }
      }
      return count;
    }
}