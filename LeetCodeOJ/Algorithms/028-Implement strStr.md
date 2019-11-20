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
        int index = 0;
        int i = 1;
        while (i < pLen) {
            if (pattern.charAt(i) == pattern.charAt(index)) {
                index++;
                next[i] = index;
                i++;
            } else {
                if (index != 0) {
                    index = next[index - 1];
                } else {
                    next[i] = index;
                    i++;
                }
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