class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;

        int i = 0;
        int j = n-1;

        while(i <= j){
            int mid = i + (j-i)/2;

            int missing = arr[mid] - mid - 1;
            if (missing < k)
                i = mid + 1;
            else
                j = mid - 1;
        }

        return i + k;
    }
}