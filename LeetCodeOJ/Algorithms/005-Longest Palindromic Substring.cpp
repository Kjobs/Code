string longestPalindrome(string s) {
    int n = s.length();
    if(n < 2){
    	return s;
	}
    int left,right;
    int pos=0;
    int maxLen = 0;
    int i=0;
    while(i<n){
    	if(n-i<=maxLen/2) break;
    	left = right = i;
    	while(right<n-1 && s[right]==s[right+1]) right++;
    	i = right+1;
    	while(right<n-1 && left>0 && s[right+1]==s[left-1]){
    		left--;
    		right++;
		}
		if(maxLen < right-left+1){
			pos = left;
			maxLen = right-left+1;
		}
	}
    return s.substr(pos,maxLen);    
}
