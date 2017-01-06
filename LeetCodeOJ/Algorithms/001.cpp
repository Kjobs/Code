class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> res;
	    unordered_map<int, int> ml;
	    for (int i = 0; i < nums.size(); i++)
    	{
	    	int t = target - nums[i];
	    	if (ml.count(t))
	    	{
	    		res.push_back(ml[t]);
	    		res.push_back(i);
	    	}
	    	ml[nums[i]] = i;
    	}
    	return res;
    }
};
