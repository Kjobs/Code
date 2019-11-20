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
        int j = 0;

        while (i < hLen) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
            }
            if (j == nLen) {
                return i - j;
                // j = next[j - 1];
            } else if (i < hLen && needle.charAt(j) != haystack.charAt(i)) {
                if (j != 0) {
                    j = next[j - 1];
                } else {
                    i++;
                }
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
