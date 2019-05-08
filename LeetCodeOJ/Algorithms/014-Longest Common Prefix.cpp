class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if(strs.empty()) return "";
        string res = "";
        int vecLength = strs.size();
        int minLength = strs[0].length();
        for (int i = 1; i < vecLength; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
            }
        }

        for (int i = 0; i < minLength; i++) {
            char ch = strs[0][i];
            for (int j = 1; j < vecLength; j++) {
                if (ch != strs[j][i]) return res;
            }
            res = res + ch;
        }
        return res;
    }
};
