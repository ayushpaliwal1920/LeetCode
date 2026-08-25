class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();

        for(int i = 0 ; i< words.length ; i++){
            if(pattern.length() != words[i].length()){
                continue;
            }
            if(check(words[i] , pattern)){
                ans.add(words[i]);
            }
        }
        return ans;
    }
    public boolean check(String s , String pattern){
        HashMap<Character , Character> mp1 = new HashMap<>();
        HashMap<Character , Character> mp2 = new HashMap<>();

        for(int i = 0 ; i< pattern.length() ; i++){
            char cs = s.charAt(i);
            char ps = pattern.charAt(i);

            if(mp1.containsKey(cs) && mp1.get(cs) != ps){
                return false;
            }else if(mp2.containsKey(ps) && mp2.get(ps) != cs){
                return false;
            }else{
                mp1.put(cs , ps);
                mp2.put(ps , cs);
            }
        }

        return true;
    }
}