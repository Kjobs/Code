class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        StringBuilder sb = new StringBuilder();
        String str = countAndSay(n - 1);
        System.out.println(str);
        int strLen = str.length();
        int index = 0;
        int count = 0;
        while (index < strLen) {
            if (index != 0 && str.charAt(index) != str.charAt(index - 1)) {
                sb.append(count).append(str.charAt(index - 1));
                count = 0;
            }
            count++;
            index++;
        }
        sb.append(count).append(str.charAt(index - 1));
        return sb.toString();
    }
}
