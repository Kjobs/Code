void generateParenthesisDFS(int n, int left, int right, string str, vector<string> &res) {
	if (n == right) res.push_back(str);
	else{
		if (left < n) generateParenthesisDFS(n, left + 1, right, str + '(', res);
		if (left > right) generateParenthesisDFS(n, left, right + 1, str + ')', res);
	}
}

vector<string> generateParenthesis(int n) {
	vector<string> res;
	generateParenthesisDFS(n, 0, 0, "", res);
	return res;
}
