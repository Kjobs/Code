/*回溯*/
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(String s, int pos, List<String> cur, List<String> res) {
        if (cur.size() == 4) {
            if (pos == s.length()) {
                res.add(String.join(".", cur));
            }
            return;
        }
        for (int i = 1; i <= 3 ; i++) {
            if (pos + i > s.length()) {
                break;
            }
            String segment = s.substring(pos, pos + i);
            // 验证每个小段的合法性
            if ((segment.startsWith("0") && segment.length() > 1)|| (i == 3 && Integer.valueOf(segment) > 255)) {
                continue;
            }
            cur.add(segment);
            helper(s, pos + i, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
