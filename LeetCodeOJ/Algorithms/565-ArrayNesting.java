/*利用所有元素不重复且每个元素必是1~N-1之间的某一个元素的特征，有以下两种方法*/
/*利用额外数组空间visited[]标记*/
class Solution {
    public int arrayNesting(int[] nums) {
        int maxSLength = 0;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int j = nums[i];
                int count = 1;
                while (nums[j] != nums[i]) {
                    visited[j] = true;
                    count++;
                    j = nums[j];
                }
                maxSLength = Math.max(maxSLength, count);
            }
        }
        return maxSLength;
    }
}

/*不用额外空间，在原数组上修改，访问过的元素改为-1*/
class Solution {
    public int arrayNesting(int[] nums) {
        int maxSLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int count = 0;
            while (nums[j] != -1) {
                count++;
                int k = nums[j];
                nums[j] = -1;
                j = k;
            }
            maxSLength = Math.max(maxSLength, count);
        }
        return maxSLength;
    }
}
