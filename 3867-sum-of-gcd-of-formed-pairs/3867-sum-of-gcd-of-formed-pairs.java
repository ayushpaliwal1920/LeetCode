class Solution {
    public long gcdSum(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int n = nums.length;

        int[] prefixGcd =  new int[n];

        for(int i = 0 ; i< n ; i++){
            maxi = Math.max(maxi , nums[i]);
            prefixGcd[i] = gcd(nums[i] , maxi);
        }

        Arrays.sort(prefixGcd);

        int i = 0;
        int j = n-1;

        long ans = 0;

        while(i < j){
            ans += gcd(prefixGcd[i] , prefixGcd[j]);
            i++;
            j--;
        }

        return ans;

    }

    public int gcd(int x , int y){

        while(y != 0){
            int temp = y;
            y = x % y;
            x = temp;
        }

        return x;
    }
}