class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Method : Two pointer and array :
    
    //     int i = 0;
    //     int j = 0;

    //     int n1 = nums1.length;
    //     int n2 = nums2.length;

    //     int n = n1 + n2;

    //     int[] arr = new int[n];
    //     int idx = 0;

    //     while(i < n1 && j < n2){
    //         if(nums1[i] <= nums2[j]){
    //             arr[idx] =  nums1[i];
    //             i++;
    //         }else{
    //             arr[idx] =  nums2[j];
    //             j++;
    //         }
    //         idx++;
    //     }

    //     while(i < n1){
    //        arr[idx] = nums1[i];
    //        i++;
    //        idx++;
    //     }

    //     while(j < n2){
    //        arr[idx] = nums2[j];
    //        j++;
    //        idx++;
    //     }

    //     if( (n % 2) != 0){
    //         int mid = (n-1)/2;
    //         return arr[mid];
    //     }

    //     int mid = n/2;

    //    return ((double)(arr[mid] + arr[mid - 1]) / 2.0);


    // Method 2 : binary Search Method :

    if( nums1.length > nums2.length){
        return findMedianSortedArrays(nums2 , nums1);
    }

    int n1 = nums1.length;
    int n2 = nums2.length;

    int low  = 0;
    int high = n1;

    while(low <= high){
        int cut1 = low + (high - low)/2;
        int cut2 = (n1+n2+1)/2 - cut1;

        int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];
        int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];

        int r1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
        int r2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

        if(l1 <= r2 && l2 <= r1){
            if((n1+n2) % 2 == 0){
                double ans = (double) (Math.max(l1 , l2) + Math.min(r1 , r2)) /2 ;
                return ans;     
            }

            return Math.max(l1,l2);
        }else if(l1 > r2){
            high = cut1 - 1;
        }else{
            low = cut1 + 1;
        }

    }

    return 0.0 ;
























    }
}