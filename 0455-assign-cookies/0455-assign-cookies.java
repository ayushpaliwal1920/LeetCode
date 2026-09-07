class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int l = 0 ; 
        int r = 0;

        while(r < s.length && l < g.length ){
            if(g[l] <= s[r]){
                count++;
                r++;
                l++;
            }else{
                r++;
            }
    
        }
        return count;

    }
}