class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int res = 65535;
        unsigned int numslen = nums.size();
        if (numslen < 3) return res;
        sort(nums.begin(), nums.end());
        unsigned int i = 0;
        while (i < numslen - 2){
            unsigned int start = i + 1;
            unsigned int end = numslen - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (abs(sum - target) < abs(res - target)) {
                    res = sum;
                }
                else if (sum <= target) { start++; }
                else { end--; }
            }
            i++;
            while (i < numslen - 2 && nums[i] == nums[i - 1]) { i++; }
        }
        return res;
    }
};
