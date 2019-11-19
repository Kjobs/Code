class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int numsLen = nums.length;
        if (numsLen == 0) {
            return result;
        }
        int[] flag = new int[numsLen + 1];
        for (int i = 0; i < numsLen; i++) {
            flag[nums[i]] += 1;
        }
        for (int i = 0; i < numsLen + 1; i++) {
            if (flag[i] == 2) {
                result.add(i);
            }
        }
        return result;
    }
}
