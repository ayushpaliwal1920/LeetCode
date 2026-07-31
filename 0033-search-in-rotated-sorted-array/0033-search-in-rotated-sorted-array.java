class Solution {
    public int search(int[] arr, int target) {
        int n  = arr.length;
        int st = 0;
        int end = n-1;

        while(st <= end){
            int mid = st + (end - st)/2;
            if(target == arr[mid]){ return mid;}
            else if( arr[mid] < arr[end]){
                if( target <= arr[end] && target > arr[mid]){
                    st = mid+1;
                }else{
                    end = mid-1;
                }
            }else{
                if(target <= arr[mid] && target >= arr[st]){
                    end = mid-1;
                }else{
                    st = mid+1;
                }
            }
        }
        return -1;
      
    }


}