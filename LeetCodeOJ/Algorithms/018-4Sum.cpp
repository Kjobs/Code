class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> res = {};
        unsigned int numslen = nums.size();
        if (numslen < 4) return res;
        sort(nums.begin(), nums.end());
        unsigned int i = 0;
        while (i < numslen - 3){
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3]>target) break;
            while (i < numslen - 3 && nums[i] + nums[numslen - 3] + nums[numslen - 2] + nums[numslen - 1] < target) i++;
            unsigned int index_end = numslen - 1;
            while (index_end - i >2)
            {
                unsigned int start = i + 1;
                unsigned int end = index_end - 1;
                while (start < end) {
                    int sum = nums[i] + nums[start] + nums[end] + nums[index_end];
                    if (sum == target) {
                        res.push_back({ nums[i], nums[start], nums[end], nums[index_end] });
                        end--;
                        while(start < end && nums[end] == nums[end + 1]) { end--; }
                        while(start < end && nums[start] == nums[start-1]) { start++; }
                    }
                    else if (sum > target) { end--; }
                    else { start++; }
                }
                index_end--;
                while (index_end - i > 2 && nums[index_end] == nums[index_end + 1]) {
                    index_end--;
                }
            }
            i++;
            while (i < numslen - 3 && nums[i] == nums[i - 1]) { i++; }
        }
        return res;
    }
};

//Runtime: 8 ms, faster than 99.69% of C++ online submissions for 4Sum.
//Memory Usage: 9.3 MB, less than 71.17% of C++ online submissions for 4Sum.
