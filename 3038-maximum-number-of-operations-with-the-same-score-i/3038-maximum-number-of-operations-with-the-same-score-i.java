class Solution {
    public int maxOperations(int[] nums) {
        int n = nums.length;
        int target = nums[0] + nums[1];
        int operations = 1;  

        int i = 2;

        while (i + 1 < n) {
            if (nums[i] + nums[i + 1] == target) {
                operations++;
                i += 2;
            } else {
                break;
            }
        }

        return operations;
    }
}