class Solution {
    public boolean lemonadeChange(int[] bills) {

        int countf = 0;
        int countt = 0;

        for(int i = 0 ; i< bills.length ; i++){
            if(bills[i] == 5){
                countf++;
            }else if(bills[i] == 10){
                int temp = (bills[i]-5)/5;
                if(temp <= countf){
                    countf -= temp;
                    countt++;
                }else{
                    return false;
                }
            }else{
                if(countt >=1 && countf >=1){
                    countt--;
                    countf--;
                }else if(countf >= 3){
                    countf -= 3;
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}