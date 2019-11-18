class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode node = p;
        while (p.next != null && p.next.next != null) {
            ListNode tmp = new ListNode(p.next.val);
            p.next = p.next.next;
            ListNode tmp2 = p.next.next;
            p.next.next = tmp;
            p.next.next.next = tmp2;
            p = p.next.next;
        }
        return node.next;
    }
}
