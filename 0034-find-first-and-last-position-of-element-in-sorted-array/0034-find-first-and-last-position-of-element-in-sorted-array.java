class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        ans[0] = firstOccurrence(nums, target);
        ans[1] = lastOccurrence(nums, target);

        return ans;
    }

    public int firstOccurrence(int[] nums, int target) {
        int st = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (nums[mid] == target) {
                ans = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public int lastOccurrence(int[] nums, int target) {
        int st = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (nums[mid] == target) {
                ans = mid;
                st = mid + 1;
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
}