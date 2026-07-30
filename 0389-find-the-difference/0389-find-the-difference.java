class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character , Integer> mp = new HashMap<>();

        for(char ch : s.toCharArray()){
            mp.put(ch , mp.getOrDefault(ch ,0)+1);
        }

        for(char ch : t.toCharArray()){
            mp.put(ch , mp.getOrDefault(ch ,0) - 1);
        }

       for (char ch : mp.keySet()) {
            if (mp.get(ch) != 0)
                return ch;
        }

        return ' ';
    }
}