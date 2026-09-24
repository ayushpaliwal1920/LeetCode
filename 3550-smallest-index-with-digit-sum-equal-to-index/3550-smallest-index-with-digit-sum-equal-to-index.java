class Solution {
    public int smallestIndex(int[] nums) {
        for(int i = 0 ; i< nums.length ; i++){
            if(sumofdigit(nums[i]) == i){
                return i ;
            }
        }

        return -1;
    }

    public int sumofdigit(int n){
        int c = n;

        int sum = 0;

        while(c > 0){
            int r = c%10;
            sum += r;
            c = c/10;
        }

        return sum ;
    }
}