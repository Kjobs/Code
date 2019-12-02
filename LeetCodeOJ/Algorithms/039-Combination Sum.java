class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 解决break步骤出现的判断出错，不加break则不用排序
        Arrays.sort(candidates);
        helper(0, 0, candidates, target, result, new ArrayList<>());
        return result;
    }

    private void helper(int start, int sum, int[] candidates, int target, List<List<Integer>> result, List<Integer> list) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 当sum大于target后不用再遍历之后的i，提高效率
            int tmp = sum + candidates[i];
            if (tmp > target) break;
           
            list.add(candidates[i]);
            // 递归添加，类似于访问子节点
            helper(i, tmp, candidates, target, result, list);
            list.remove(list.size() - 1);
        }
    }
}

/* 类似于DFS递归实现，这里采用回溯法 */
