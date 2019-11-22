class Solution {
    public void nextPermutation(int[] nums) {
        int numsLen = nums.length;
        for (int i = numsLen - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int j = numsLen - 1;
                for (; j > i - 1; j--) {
                    if (nums[j] > nums[i - 1]) {
                        break;
                    }
                }
                int temp = nums[i - 1];
                nums[i - 1] = nums[j];
                nums[j] = temp;
                reverse(i, numsLen - 1, nums);
                return;
            }
        }
        reverse(0, numsLen - 1, nums);
    }

    public void reverse(int x, int y, int[] nums) {
        while (x < y) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
            x++;
            y--;
        }
    }
}
