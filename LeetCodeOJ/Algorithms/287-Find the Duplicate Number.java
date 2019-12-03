class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int find = 0;
        while (find != slow) {
            slow = nums[slow];
            find = nums[find];
        }
        return find;
    }
}

/* 通过快慢指针发现循环节点，再次循环找到循环节点起始位置 */
