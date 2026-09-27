class Solution {
    public int characterReplacement(String s, int k) {
       Map<Character , Integer> mp = new HashMap<>();

       int maxf = 0; // maxfrequency 
       int maxans = 0;

       int left = 0;
       
       for(int i = 0; i< s.length() ; i++){
           char ch = s.charAt(i);
           mp.put(ch , mp.getOrDefault(ch , 0)+1);

           maxf = Math.max(maxf , mp.get(ch));

           int window = (i - left)+1;

           int replace = window - maxf;

           if(replace > k){
               mp.put(s.charAt(left), mp.get(s.charAt(left)) - 1);
               left++;
           }

           maxans = Math.max(maxans , i-left+1 );

       }

       return maxans;
    }
}