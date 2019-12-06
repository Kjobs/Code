class Solution {
    /**
     * step1: 从右向左，找到第一个非升序的（即nums[i]>nums[i-1]）的元素下标，p=i-1；
     * step2: 从右向左，找到第一个大于nums[p]的元素下标q；
     * step3: 调换nums[p]和nums[q]；
     * step3: 将p后面的元素颠倒顺序
     * 特殊情况：已经是从大到小的顺序排列的数组，应返回其逆序（从小到大）。
     */
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
