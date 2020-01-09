class Solution {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x = x ^ num;
        }
        return x;
    }
}

/* 异或运算：相同为0，不同为1；重复的数进行异或运算等于0，0与任何数异或是任何数*/
