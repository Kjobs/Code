class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return result;
    }

    public void helper(int start, int[] nums, List<List<Integer>> result) {
        if (start == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            // 加入Set去掉重复元素；
            // 之前的想法是比较两个元素（调换与被调换）是否相同防止调换，但是这样会漏掉调换元素已经使用过的情况；
            // 加入Set后，上述情况就都可以避免了
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            
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
