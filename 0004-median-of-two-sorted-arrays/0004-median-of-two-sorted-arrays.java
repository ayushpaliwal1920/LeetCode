class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;

        int n1 = nums1.length;
        int n2 = nums2.length;

        int n = n1 + n2;

        int[] arr = new int[n];
        int idx = 0;

        while(i < n1 && j < n2){
            if(nums1[i] <= nums2[j]){
                arr[idx] =  nums1[i];
                i++;
            }else{
                arr[idx] =  nums2[j];
                j++;
            }
            idx++;
        }

        while(i < n1){
           arr[idx] = nums1[i];
           i++;
           idx++;
        }

        while(j < n2){
           arr[idx] = nums2[j];
           j++;
           idx++;
        }

        if( (n % 2) != 0){
            int mid = (n-1)/2;
            return arr[mid];
        }

        int mid = n/2;

       return ((double)(arr[mid] + arr[mid - 1]) / 2.0);

    }
}