class Solution {
public:
    string rom(int n,char x,char y,char z){
        string str;
        if (n <= 3) str.append(n, x);
        if (n == 4) str = str+x+y;
        if (n == 5) str = str + y;
        if (n > 5 && n <= 8) {
            str = str + y;
            str.append(n - 5, x);
        }
        if (n == 9) str = str + x + z;
        return str;
    }

    string intToRoman(int num) {
        string res;
        int t1= num / 1000;
        if (t1 != 0) {
            res.append(t1, 'M');
            num = num-t1*1000;
        }
        int t2 = num / 100;
        if (t2 != 0){
            string s = rom(t2, 'C', 'D', 'M');
            res.append(s);
            num = num-t2*100;
        }
        int t3 = num / 10;
        if (t3 != 0){
            string s = rom(t3, 'X', 'L', 'C');
            res.append(s);
            num = num - t3 * 10;
        }
        if (num != 0) res.append(rom(num, 'I', 'V', 'X'));
        return res;
    }
};
