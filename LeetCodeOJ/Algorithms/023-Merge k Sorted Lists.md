```java
class Solution {
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode p = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                p.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return node.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int listLen = lists.length;
        if (listLen <= 0) {
            return null;
        }
        List<ListNode> listNodes = new ArrayList<>(Arrays.asList(lists));
        int mergeListLen = listNodes.size();
        while (mergeListLen > 1) {
            List<ListNode> lns = new ArrayList<>();
            int i=0;
            while (i<mergeListLen-1){
                lns.add(merge2Lists(listNodes.get(i),listNodes.get(i+1)));
                i=i+2;
            }
            if (i == mergeListLen-1){
                lns.add(listNodes.get(i));
            }
            mergeListLen = lns.size();
            listNodes = lns;
        }
        return listNodes.get(0);
    }
}

/* 分治法：类似于归并排序，时间复杂度为O(N*logk) */

```
