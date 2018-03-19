class Solution {
public:
    bool isPalindrome(int x) {
        if(x < 0)
            return false;
        int mid_num;
        int origin_x = x;
        int reverse_x = 0;
        while(x != 0){
            mid_num = x%10;
            if(abs(reverse_x) > INT_MAX/10)
                return 0;
            reverse_x = reverse_x*10 + mid_num;
            x = x/10;
        }
        if(origin_x == reverse_x)
            return true;
        else
            return false;
    }
};
