/**
 * @author kobs
 * @date 2019/11/20
 */
public class BitManipulation {

    int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return a;
    }

    int sub(int a, int b) {
        return add(a, -b);
    }

    int mul(int a, int b) {
        int flag = ((a < 0) ^ (b < 0)) ? -1 : 1;
        int m = Math.abs(a);
        int n = Math.abs(b);
        int sum = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                sum = add(sum, m);
            }
            m = m << 1;
            n = n >> 1;
        }
        return (flag == 1) ? sum : -sum;
    }

    int div(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int flag = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int res = 0;
        if (b == 1) {
            return Integer.valueOf(String.valueOf((flag == 1) ? a : -a));
        }
        while (a >= b) {
            int temp = 0;
            while (a >= (b << temp)) {
                temp++;
            }
            res += 1 << (temp - 1);
            a -= (b << (temp - 1));

        }
        return (flag == 1) ? res : -res;
    }

    public static void main(String[] args) {

        BitManipulation ic = new BitManipulation();

        int a = 257;
        int b = -2;

        System.out.println(ic.add(a, b));
        System.out.println(ic.sub(a, b));
        System.out.println(ic.mul(a, b));
        System.out.println(ic.div(a, b));
    }
}
