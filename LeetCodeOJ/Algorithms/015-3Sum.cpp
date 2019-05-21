class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res = {};
        unsigned int numslen = nums.size();
        if(numslen < 3) return res;
        sort(nums.begin(), nums.end());
        unsigned int i = 0;
        while(i < numslen - 2){
            unsigned int start = i + 1;
            unsigned int end = numslen - 1;
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] == 0) {
                    res.push_back({ nums[i], nums[start], nums[end] });
                    end--;
                    while (start < end && nums[end] == nums[end+1]) { end--;	}
                }
                else if (nums[i] + nums[start] + nums[end] > 0) { end--; }
                else { start++; }
            }
            i++;
            while (i < numslen-2 && nums[i] == nums[i - 1]) { i++; 	}
        }	
        return res;
    }
};

// beats 99.8% of cpp submitions
