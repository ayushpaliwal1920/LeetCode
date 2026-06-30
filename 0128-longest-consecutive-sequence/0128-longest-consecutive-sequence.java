class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        int maxlen = 0;

        for( int i : nums){
            st.add(i);
        }

        for( int num : st){
            
            if( !st.contains(num - 1)){
                int currNum = num;
                int currlen = 1;

                while(st.contains(currNum + 1)){
                    currlen++;
                    currNum++;
                }

                maxlen = Math.max(currlen , maxlen);
            }
        }
        return maxlen;
    }

}