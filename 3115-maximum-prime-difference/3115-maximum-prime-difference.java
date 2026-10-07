class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int n = nums.length;
        int max = 0;

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i = 0 ; i<n ; i++){
            if(isPrime(nums[i]) && first == Integer.MIN_VALUE){
                first = i;
            }else if(isPrime(nums[i])){
                second = i;
            }
            

            if(first != Integer.MIN_VALUE && second != Integer.MIN_VALUE){
                max = Math.max(max , second-first);
            }
        }

        return max;
    }

    public boolean isPrime(int n){ 
        
        if(n <= 1){
            return false;
        }

        if(n == 2) return true;
        if(n % 2 == 0) return false;

        for(int i = 3 ; i <= n/i ; i+=2){
            if( n % i == 0){
                return false;
            }
        }
        return true;

    }

}