class Solution {
public:
    int cti(char c){
        int res = 0;
        char ac[7] = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
        int ai[7] = { 1, 5, 10, 50, 100, 500, 1000 };
        for (int j = 0; j < 7; j++){
            if (c == ac[j]) {
                res = ai[j];
            }
        }
        return res;
    }

    int romanToInt(string s) {
        int res = 0,i;
        for (i = 0; i < s.size(); i++){
            int val = cti(s[i]);
            if (i == s.size() - 1 || cti(s[i])>=cti(s[i+1])) res += val;
            else res -= val;
        }
        return res;
    }
};
