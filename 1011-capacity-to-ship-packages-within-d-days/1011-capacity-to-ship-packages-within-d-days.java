class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int n = weights.length;
        int sum = 0;
        int i = 0; 

        for(int num : weights){
            sum += num;
            i = Math.max(i , num);
        }

        int j = sum;

        while(i <= j){
            int mid = i + (j-i)/2;

            if(possible(mid , days , weights)){
                j = mid -1 ;
            }else{
                i = mid+1;
            }
        }

        return i;
        
    }

    public boolean possible(int c , int days , int[] weights){

        int currload = 0;
        int currday = 1;
            
        for(int num : weights){
            if((currload + num) <= c){
                currload += num;
            }else{
                currday++;
                currload = num;
            }
        }

        if(currday <= days) return true;

        return false;
        
    }
}