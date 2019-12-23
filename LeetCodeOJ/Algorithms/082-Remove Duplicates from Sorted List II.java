/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode p = node;
        while (p.next != null) {
            if (p.next.next != null && p.next.val == p.next.next.val) {
                ListNode q = p.next.next;
                while (q.next != null && q.val == q.next.val) {
                    q = q.next;
                }
                p.next = q.next;
            } else {
                p = p.next;
            }
        }
        return node.next;
    }
}
