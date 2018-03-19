class Solution {
public:
    int reverse(int x) {
        int mid_num;
        int reverse_x = 0;
        while(x != 0){
            mid_num = x%10;
            if(abs(reverse_x) > INT_MAX/10)
                return 0;
            reverse_x = reverse_x*10 + mid_num;
            x = x/10;
        }
        return reverse_x;
    }
};
