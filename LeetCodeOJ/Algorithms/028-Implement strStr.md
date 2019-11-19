#### KMP算法实现
```java
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return 0;
        }
        int hLen = haystack.length();
        int nLen = needle.length();
        if (nLen > hLen) {
            return -1;
        }
        if (nLen == 0) {
            return 0;
        }
        int[] next = getNext(needle);
        int i = 0;

        while (i <= hLen - nLen) {
            boolean flag = true;
            for (int j = 0; j < nLen; j++) {
                if (needle.charAt(0) != haystack.charAt(i)) {
                    flag = false;
                    i++;
                    break;
                } else if (needle.charAt(j) != haystack.charAt(i + j)) {
                    flag = false;
                    i = i + j - next[j - 1];
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    public int[] getNext(String pattern) {
        int pLen = pattern.length();
        int[] next = new int[pLen];
        next[0] = 0;
        for (int i = 1; i < pLen; i++) {
            int index = next[i - 1];
            while (index > 0 && pattern.charAt(index) != pattern.charAt(i)) {
                index = next[index - 1];
            }
            if (pattern.charAt(index) == pattern.charAt(i)) {
                next[i] = next[i - 1] + 1;
            } else {
                next[i] = 0;
            }
        }
        return next;
    }
}
```

#### 直接用String的indexOf方法实现
```java
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
```
