class Solution {
    public List<String> printVertically(String s) {
        String[] strarr = s.split(" ");
        int maxlen = 0;
        for(String str : strarr){
            maxlen = Math.max(str.length() , maxlen);
        }

        String[] ans = new String[maxlen];
        int i = 0;
        while( i < maxlen){
            String str = "";
            for(int j = 0; j<strarr.length ; j++){
                if(strarr[j].length() > i){
                str = str + strarr[j].charAt(i);
                }else{
                    str = str + " ";
                }
            }
          ans[i] = str.stripTrailing();
          i++;
        }

        return new ArrayList<>(Arrays.asList(ans));
    }
}