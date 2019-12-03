class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
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
            int tmp = sum + candidates[i];
            if (tmp > target) break;
            list.add(candidates[i]);
            helper(i + 1, tmp, candidates, target, result, list);
            while (i < candidates.length - 1 && candidates[i + 1] == candidates[i]) i++;
            list.remove(list.size() - 1);
        }
    }
}

/* 类似于Combination Sum I，只是candidates迭代的起始坐标需+1，防止坐标元素重复；另外需要在递归返回时加入while循环，跳过相同的元素，防止得到的结果数组重复 */
