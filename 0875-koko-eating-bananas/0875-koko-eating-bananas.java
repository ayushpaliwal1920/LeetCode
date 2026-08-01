class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Binary search 

        int low = 0;
        int high = 0;

        for(int p : piles){
            high = Math.max(high,p);
        }

        int ans = high; // max possible ans is high 

        while( low <= high){
            int mid = low + (high - low)/2 ; 

            if( canEat(piles , h , mid)){
                ans = mid;
                high = mid-1;
            }else{ 
                low = mid+1;
            }
        }
        return ans;
    }
    private boolean canEat(int[] arr ,int h , int mid){
        int hours = 0 ;

        for(int p : arr){
            hours += (int) Math.ceil( (double) p/mid); // 3/4 = 1 , 6/4 = 2 ,7/4 =2 , 11/4 = 3
            if( hours > h){ return false ;}
        }
        return true;
    }
}