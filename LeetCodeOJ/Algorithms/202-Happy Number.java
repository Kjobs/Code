/* 最简单的思路是利用一个HashSet来发现计算得到的重复平方和，发现循环并退出 */
class Solution {
    public boolean isHappy(int n) {
        if (n == 1) return true;
        Set<Integer> map = new HashSet<>();
        int num = n;
        do {
            map.add(num);
            int sum = 0;
            while (num > 0) {
                int temp = num % 10;
                sum += Math.pow(temp, 2);
                num = num / 10;
            }
            if (sum == 1) {
                return true;
            }
            num = sum;
        } while (!map.contains(num));
        return false;
    }
}

/* 发现重复数（即循环开始的数），还有一种方法是快慢指针 */
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while (true) {
            slow = findNext(slow);
            fast =findNext(fast);
            fast = findNext(fast);
            if(slow == fast) break;
        }
        return slow == 1;
    }

    private int findNext(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n /= 10;
        }
        return res;
    }
}

/* 直接利用快乐数平方和最终是1，非快乐数平方和最终是4的特点，可以简化运算 */
class Solution {
    public boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            int cur = n;
            n = 0;
            while (cur > 0) {
                int temp = cur % 10;
                n += temp * temp;
                cur /= 10;
            }
        }
        return n == 1;
    }
}
