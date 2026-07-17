class Solution {
    public int maximumScore(int a, int b, int c) {
    
        int sum = a + b + c ; 

        int max = Math.max(a , Math.max(b,c));

        int ans = Math.min(sum/2 , sum - max);

        return ans;

           
        

    }
}