class Solution {
    public void sortColors(int[] nums) {
        int x = 0;
        int y = 0;
        int z = 0;
        for (int num : nums) {
            if (num == 0) {
                x++;
            } else if (num == 1) {
                y++;
            } else {
                z++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < x) {
                nums[i] = 0;
            } else if (i >= x && i < x + y) {
                nums[i] = 1;
            } else {
                nums[i] = 2;  
            }
        }
    }
}
