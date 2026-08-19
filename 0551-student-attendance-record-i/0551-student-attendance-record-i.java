class Solution {
    public boolean checkRecord(String s) {

        int a = 0;

        for(char ch : s.toCharArray()){
            if(ch == 'A'){
                a++;
            }

            if(a >= 2){
                return false;
            }

        }

        if(s.contains("LLL")){
            return false;
        }

        return true; 
    }
}