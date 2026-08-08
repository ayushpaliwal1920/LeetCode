class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;

        int i = 0 ; 
        int j = n-1;
        long ans = 0;

        int condn = skill[0] + skill[n-1];

        while(i < j){
            if(skill[i] + skill[j] != condn){
                return -1;
            }

            ans += (long) skill[i] * skill[j];
            i++;
            j--;
        }

        return ans;
    }
}