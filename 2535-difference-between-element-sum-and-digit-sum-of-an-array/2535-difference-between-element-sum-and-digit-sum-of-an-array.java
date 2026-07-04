class Solution {
    public int differenceOfSum(int[] nums) {
        int sumDigit = 0;
        int sumNum = 0;
        int  n = nums.length;

        for(int i=0 ; i<n ; i++){
            int num = nums[i];
            while(num > 0){
                int r = num % 10;
                num = num/10;
                sumDigit += r;
            }
            sumNum += nums[i];
        }

        return Math.abs(sumNum - sumDigit);
    }

}