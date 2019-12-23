/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode p = new ListNode(-1);
        ListNode node1 = p;
        ListNode q = new ListNode(-1);
        ListNode node2 = q;
        while (head != null) {
            ListNode tmp = new ListNode(head.val);
            if (head.val < x) {
                p.next = tmp;
                p = p.next;
            } else {
                q.next = tmp;
                q = q.next;
            }
            head = head.next;
        }
        p.next = node2.next;
        return node1.next;
    }
}
