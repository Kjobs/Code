最初采用先排序后合并的方法，运行超时；
```java
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] < o2[1] ? -1 : 1;
                return o1[0] < o2[0] ? -1 : 1;
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.stream(intervals[0]).boxed().collect(Collectors.toList()));
        for (int i = 1; i < intervals.length; i++) {
            int last = res.size() - 1;
            if (intervals[i][0] <= res.get(last).get(1)) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(Math.min(res.get(last).get(0), intervals[i][0]));
                tmp.add(Math.max(res.get(last).get(1), intervals[i][1]));
                res.remove(last);
                res.add(tmp);
            } else {
                res.add(Arrays.stream(intervals[i]).boxed().collect(Collectors.toList()));
            }
        }
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            int[] arr = new int[2];
            arr[0] = res.get(i).get(0);
            arr[1] = res.get(i).get(1);
            result[i] = arr;
        }
        return result;
    }
}
```
由于采用Arrays库的sort方法，并且重写的比较因子Comparator<>{}，所以猜想可能是排序导致的超时情况；

去掉排序，在合并过程中按序插入，类似于插入排序；
```java
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            int intX = intervals[i][0];
            int intY = intervals[i][1];
            List<Integer> intervalsI = new LinkedList<>();
            intervalsI.add(intX);
            intervalsI.add(intY);
            // 区间小于最小结果区间
            if (res.size() == 0 || intY < res.get(0).get(0)) {
                res.add(0, intervalsI);
                continue;
            }
            int last = res.size() - 1;
            // 区间大于最大区间
            if (intX > res.get(last).get(1)) {
                res.add(intervalsI);
                continue;
            }
            int j = last;
            while (j >= 0) {
                int resX = res.get(j).get(0);
                int resY = res.get(j).get(1);
                // 合并后大于最大区间
                if (intX > resY) {
                    j++;
                    break;
                }
                // 发生区间重复，删除结果区间中的重复区间
                if ((intX >= resX && intX <= resY) || (intY >= resX && intY <= resY) ||
                        (resX >= intX && resX <= intY) || (resY >= intX && resY <= intY)) {
                    res.remove(j);
                    intX = Math.min(resX, intX);
                    intY = Math.max(resY, intY);
                    j--;
                    continue;
                } else if (j > 0 && intX > res.get(j - 1).get(1) && intY < resX) {
                    // 区间在结果集中两个区间之间
                    break;
                }
                j--;
            }
            // 将区间加入结果集
            List<Integer> tmp = new LinkedList<>();
            tmp.add(intX);
            tmp.add(intY);
            if (j == -1) {
                j = 0;
            }
            res.add(j, tmp);
        }
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            int[] arr = new int[2];
            arr[0] = res.get(i).get(0);
            arr[1] = res.get(i).get(1);
            result[i] = arr;
        }
        return result;
    }
}
```
时间和空间的使用情况：
```text
Runtime: 6 ms, faster than 89.07% of Java online submissions for Merge Intervals.
Memory Usage: 40 MB, less than 74.64% of Java online submissions for Merge Intervals.
```
因为有数组于列表之间的相互转换，以及列表的空间开销，所以导致时间和空间的效率不高。
