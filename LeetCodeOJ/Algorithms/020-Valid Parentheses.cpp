class Solution {
public:
    bool isValid(string s) {
        stack<char> chs;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '(' || s[i] == '[' || s[i] == '{') chs.push(s[i]);
            else {
                if (chs.empty()) return false;
                if (s[i] == ')' && chs.top() != '(') return false;
                if (s[i] == ']' && chs.top() != '[') return false;
                if (s[i] == '}' && chs.top() != '{') return false;
                chs.pop();
            }
        }
        return chs.empty();
    }
};
