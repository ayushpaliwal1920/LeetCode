class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int n : nums){
            max = Math.max(max , n);
            min = Math.min(min , n);
        }
        return gcd(max  , min);
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