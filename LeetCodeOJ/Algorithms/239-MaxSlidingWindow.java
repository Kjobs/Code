class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        // 双向队列，队列存数组元素相应的下标
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 若队列末尾值小于当前元素，则删除
            while (!list.isEmpty() && nums[list.peekLast()] <= nums[i]) {
                list.pollLast();
            }
            // 添加当前元素进队列
            list.addLast(i);
            // 若队首元素下标不在窗口内，则删除
            if (list.peekFirst() <= i - k) {
                list.pollFirst();
            }
            // 从下标k - 1处开始存储结果
            if (i >= k - 1) {
                res[i + 1 - k] = nums[list.peekFirst()];
            }
        }
        return res;
    }
}
