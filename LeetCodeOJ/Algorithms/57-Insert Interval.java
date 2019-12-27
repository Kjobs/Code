class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval.length == 0) return intervals;
        List<int[]> res = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            res.add(intervals[i]);
        }
        int j = intervals.length - 1;
        int intX = newInterval[0];
        int intY = newInterval[1];
        while (j >= 0) {
            int resX = res.get(j)[0];
            int resY = res.get(j)[1];
            if (intX > resY) {
                j++;
                break;
            }
            if ((intX >= resX && intX <= resY) || (intY >= resX && intY <= resY) ||
                    (resX >= intX && resX <= intY) || (resY >= intX && resY <= intY)) {
                res.remove(j);
                intX = Math.min(resX, intX);
                intY = Math.max(resY, intY);
                j--;
                continue;
            } else if (j > 0 && intX > res.get(j - 1)[1] && intY < resX) {
                break;
            }
            j--;
        }
        int[] tmp = new int[2];
        tmp[0] = intX;
        tmp[1] = intY;
        if (j == -1) {
            j = 0;
        }
        res.add(j, tmp);
        int[][] r = new int[res.size()][2];
        return res.toArray(r);
    }
}

/* 直接粘贴了上一题的插入部分，可以解决问题，运行时间2ms，效率太低。 */
