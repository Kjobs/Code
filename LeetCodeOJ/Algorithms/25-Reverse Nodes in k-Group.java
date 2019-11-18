class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;

        ListNode p = node;
        int nodeLen = 0;
        while (p.next != null) {
            nodeLen++;
            p = p.next;
        }

        while (nodeLen >= k){
            for (int i = 0; i < k-1; i++) {
                ListNode q = pre.next;
                pre.next = head.next;
                head.next = pre.next.next;
                pre.next.next = q;
            }
            pre = head;
            head = head.next;
            nodeLen -= k;
        }
        return node.next;
    }
}
