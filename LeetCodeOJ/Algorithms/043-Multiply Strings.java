class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] d = new int[len1 + len2];

        String s1 = new StringBuilder(num1).reverse().toString();
        String s2 = new StringBuilder(num2).reverse().toString();
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                d[i + j] += (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d.length - 1; i++) {
            if (d[i] >= 10) {
                int temp = d[i];
                d[i] = temp % 10;
                d[i + 1] += temp / 10;
            }
            sb.insert(0, d[i]);
        }
        sb.insert(0, d[d.length - 1]);
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
