class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
        }

        int j = n - 1;
        for (int i = n; i < 2 * n; i++) {
            ans[i] = nums[j];
            j--;
        }

        return ans;
    }
}