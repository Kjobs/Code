class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1.0 / (myPow(x, Integer.MAX_VALUE) * x);
            }
            return 1.0 / myPow(x, -n);
        }
        double tmp = myPow(x, n / 2);
        if (n % 2 == 0) return tmp * tmp;
        else return tmp * tmp * x;
    }
}
