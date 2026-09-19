class Solution {
    long m = (long) 1e9 + 7;

    public int countNicePairs(int[] nums) {
        int n = nums.length;
        long pairs = 0;

        HashMap<Long, Integer> mp = new HashMap<>();
      
        for(int num : nums){
            long temp = num - rev(num);
            int count = mp.getOrDefault(temp , 0);
            
            pairs += count;
            
            pairs = pairs % m;

            mp.put(temp , count+1);
        }

        return (int) pairs;
        
    }
    public int rev(int n ){
        String s = Integer.toString(n);
        StringBuilder str = new StringBuilder(s);
        s = str.reverse().toString();
        
        return Integer.parseInt(s);
    }
}