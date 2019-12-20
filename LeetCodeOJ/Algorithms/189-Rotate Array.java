class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1 || k == 0) return;
        k = k % nums.length;
        int i = 0;
        // 判断指针是否回到初始位置
        int rep = i;
        // 用于循环结束判断
        int count = nums.length;
        int next;
        int pre = nums[i];
        do {
            next = (i + k) % nums.length;
            int temp = nums[next];
            nums[next] = pre;
            count--;
            pre = temp;
            i = next;
            // 指针回到初始位置，需要将指针+1，若旋转未结束则需再次进入循环旋转
            if (i == rep && i < k) {
                i++;
                rep = i;
                pre = nums[i];
            }
        } while (count != 0);
    }
}
