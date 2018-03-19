class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int start = 0;
        int maxlen = 0;
        int tables[256];
        for(int i=0; i<256; i++)
            tables[i] = -1;
        for(int i=0; i<s.length(); i++)
        {
            if(tables[s[i]] != -1)
                while(start <= tables[s[i]])
                    tables[s[start++]] = -1;
            if(i-start+1 > maxlen)
                maxlen = i-start+1;
            tables[s[i]] = i;
        }
        return maxlen;
    }
};
