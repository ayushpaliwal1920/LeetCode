class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        int count = 0;

        int[] f = new int[60];

        for(int t : time){
            int rem = t % 60;
            int needed = (60 - rem)%60;

            count += f[needed];

            f[rem]++;
        }

        return count;
    }
}