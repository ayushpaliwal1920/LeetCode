class Solution {
    public long sumAndMultiply(int n) {
        String str = String.valueOf(n);

        if( n == 0) return 0;

        int sum = 0;

        StringBuilder ans = new StringBuilder();

        for(int i = 0 ; i< str.length() ; i++){
            char c = str.charAt(i);

            if( c != '0'){
                ans.append(c);

                sum += (c - '0');
            }
        }
 
        if( ans.length() == 0) return 0;

        return Long.parseLong(ans.toString()) * sum;



    }
}