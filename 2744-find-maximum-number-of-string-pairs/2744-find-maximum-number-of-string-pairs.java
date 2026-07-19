class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int n = words.length;
        int ans = 0;

        for(int i = 0 ; i< n-1 ; i++){
            StringBuilder stri = new StringBuilder(words[i]);
            for(int j = i+1 ; j < n ; j++){
                StringBuilder strj = new StringBuilder(words[j]);
                if( stri.toString().equals(strj.reverse().toString())){
                    ans++;
                }
            }
        }

        return ans;
    }
}