/*一句话代码，直接比较正确的类型*/
class Solution {
 public boolean detectCapitalUse(String word) {
      return word.equals(word.toLowerCase()) || word.equals(word.toUpperCase()) ||  word.equals(Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase());
    }
}

/*O(n)遍历比较的方式*/
class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;
        boolean flag = false;
        if (word.charAt(0) >= 97) {
            flag = true;
        }
        int i = 1;
        if (flag) {
            while (i < word.length()) {
                char ch = word.charAt(i);
                if (ch >= 65 && ch <= 90) {
                    return false;
                }
                i++;
            }
        }
        else {
            char ch1 = word.charAt(i);
            i++;
            if (ch1 >= 97) {
                while (i < word.length()) {
                    char ch = word.charAt(i);
                    if (ch >= 65 && ch <= 90) {
                        return false;
                    }
                    i++;
                }
            } else {
                while (i < word.length()) {
                    char ch = word.charAt(i);
                    if (ch >= 97) {
                        return false;
                    }
                    i++;
                }
            }
        }
        return true;
    }
}
