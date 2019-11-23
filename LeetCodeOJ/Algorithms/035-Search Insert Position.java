class Solution {
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;
        int numsLen = nums.length;
        if (target > nums[numsLen - 1]) return numsLen;
        for (int i = 0; i < numsLen; i++) {
            if (target == nums[i]) {
                return i;
            } else if (target > nums[i] && target < nums[i + 1]) {
                return i + 1;
            }
        }
        return numsLen - 1;
    }
}
