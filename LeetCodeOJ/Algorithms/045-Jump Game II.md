class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int max = 0;
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > last) {
                last = max;
                step++;
            }
            max = Math.max(max, i + nums[i]);
        }
        return step;
    }
}

/* 采用贪心算法实现（参考[博客](https://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html)） */
