class Solution {
    public int maxDistance(int[] position, int m) {
      int n = position.length ; 

      Arrays.sort(position);

      int low = 1;
      int high = position[n-1] - position[0];

      int ans = 0;

      while(low <= high){
        int mid = low + (high - low)/2;
        if(possible(position , mid , m)){
            ans = mid;
            low = mid+1;
        }else{
          high = mid -1;
        } 
      }

      return ans;
    }
    public boolean possible(int[] position, int d , int balls){
        int count = 1 ; 
        int lastPos = position[0];

        for(int i = 0 ;i < position.length ; i++){
            if((position[i] - lastPos) >= d){
                count++;
                lastPos = position[i];
            }

            if(count >= balls) return true;
        }

        return false;
    }
}