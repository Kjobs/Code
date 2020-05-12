class Solution {
    public static int[] searchRange(int[] nums, int target) {
        // 先确定目标值最左下标
        int start = getIndex(nums, target);
        // 若下标值越界或不等与目标值，则返回初始结果
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        // 寻找大于目标值的最左目标
        return new int[]{start, getIndex(nums, target + 1) - 1};
    }

    // 寻找目标值的最左下标
    public static int getIndex(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return r;
    }
}
