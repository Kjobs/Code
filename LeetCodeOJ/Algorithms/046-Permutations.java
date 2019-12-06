class Solution {
    /**
     * 采用递归实现，时间复杂度为O(n!)
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return result;
    }

    public void helper(int start, int[] nums, List<List<Integer>> result) {
        if (start == nums.length - 1) {
            // 这里也可以用流的方式将int[]转换为List，但boxed()导致效率不高
            // Arrays.stream(nums).boxed().collect(Collectors.toList());
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            helper(start + 1, nums, result);
            swap(nums, start, i);
        }
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
