动态规划：时间复杂度为O(n)
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
```

分治法（二分）：时间复杂度为O(nlog(n))
```java
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int start, int end) {
        if (start >= end) return nums[start];
        int mid = start + (end - start) / 2;
        int mLeft = helper(nums, start, mid - 1);
        int mRight = helper(nums, mid + 1, end);
        int mMid = nums[mid];
        int tmp = mMid;
        for (int i = mid - 1; i >= start ; i--) {
            tmp += nums[i];
            mMid = Math.max(mMid, tmp);
        }
        tmp = mMid;
        for (int i = mid + 1; i <= end; i++) {
            tmp += nums[i];
            mMid = Math.max(mMid, tmp);
        }
        return Math.max(mMid, Math.max(mLeft, mRight));
    }
}
```
