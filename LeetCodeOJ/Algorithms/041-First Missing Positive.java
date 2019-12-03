class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                // 对于大于数组长度的数不用排序
                if (nums[i] <= 0 || nums[i] > nums.length) break;
                // 防止出现重复的数
                if (nums[i] == nums[nums[i] - 1]) break;
                numSwap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return (i + 1);
            }
        }
        return nums.length + 1;
    }

    private void numSwap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}

/* 基于桶排序实现基于O(n)的数组排序，然后找出于下标不一致的数（这里下标需+1） */
