/*动态规划*/
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

/*斐波那契数列*/
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int i1 = 1;
        int i2 = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = i1 + i2;
            i1 = i2;
            i2 = tmp;
        }
        return i2;
    }
}
