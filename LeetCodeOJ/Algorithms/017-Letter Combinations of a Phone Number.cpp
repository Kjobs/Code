class Solution {
public:
    vector<string> letterCombinations(string digits) {
        vector<string> res = {};
        unsigned int len = digits.size();
        if (len < 1 ) { return res; }
        unordered_map<char, string> um = { { '2', "abc" }, { '3', "def" }, { '4', "ghi" }, { '5', "jkl" }, { '6', "mno" }, { '7', "pqrs" }, { '8', "tuv" }, { '9', "wxyz" } };
        for (unsigned int i = 0; i < len; i++) {
            if (digits[i] < '2' || digits[i] > '9') { return{}; }
            char ch = digits[i];
            unordered_map<char,string>::iterator  it = um.find(ch);
            string str = it->second;
            vector<string> vecstr = res;
            res.clear();
            if (i == 0) {
                for (unsigned int j = 0; j < str.size(); j++) {
                    string tmp = "";
                    tmp = tmp + str[j];
                    res.push_back(tmp);
                }
            } else if (i > 0) {
                for (unsigned int k = 0; k < vecstr.size(); k++) {
                    for (unsigned int j = 0; j < str.size(); j++) {
                        string tmp = "";
                        tmp = vecstr[k] + str[j];
                        res.push_back(tmp);
                    }
                }
            }
        }
        return res;
    }
};
