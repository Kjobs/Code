class Solution {
    public int removeDuplicates(int[] nums) {
        Arrays.sort(nums);
        int numsLen = nums.length;
        if (numsLen == 0) {
            return 0;
        }
        int res = 1;
        int index = 1;
        for (int i = 1; i < numsLen; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
                res++;
            }
        }
        return res;
    }
}
