class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;

        if(n%2 != 0) return -1;

        Map<Integer, Integer> mp = new HashMap<>();

        int i = 0 ;
        int j = n-1;

        while(i <= j){
            mp.put(skill[i]+skill[j] , mp.getOrDefault(skill[i]+skill[j] , 0)+1);
            i++;
            j--;
        }

        if(mp.size() > 1) return -1;

        i = 0;
        j = n-1;

        long ans = 0;

        while(i<j){
            ans += skill[i]*skill[j];
            i++;
            j--; 
        }

        return ans;
    }
}