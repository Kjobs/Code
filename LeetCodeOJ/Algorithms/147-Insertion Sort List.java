/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = new ListNode(-1);
        node.next = new ListNode(head.val);
        ListNode p = head.next;
        while (p != null) {
            ListNode q = node;
            boolean insertFlag = false;
            while (q.next != null) {
                if (p.val < q.next.val) {
                    ListNode tmp = q.next;
                    q.next = new ListNode(p.val);
                    q.next.next = tmp;
                    q = q.next;
                    insertFlag = true;
                    break;
                }
                q = q.next;
            }
            if (!insertFlag) {
                q.next = new ListNode(p.val);
            }
            p = p.next;
        }
        return node.next;
    }
}
