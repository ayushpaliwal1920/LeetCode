class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return gcd(nums[0] , nums[n-1]);
    }

    public int gcd(int x , int y){
        while(y != 0){
            int temp = y ;
            y = x % y;
            x = temp;
        }

        return x;
    }
}