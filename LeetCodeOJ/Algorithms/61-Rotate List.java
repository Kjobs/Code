/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode node = head;
        int nodeSize = 0;
        while (head != null) {
            nodeSize++;
            head = head.next;
        }
        int num = k % nodeSize;
        for (int i = 0; i < num; i++) {
            node = rotateListNode(node);
        }
        return node;
    }

    private ListNode rotateListNode(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode cur = node;
        ListNode res;
        while (true) {
            if (cur.next.next == null) {
                res = new ListNode(cur.next.val);
                cur.next = null;
                res.next = node.next;
                return res;
            }
            cur = cur.next;
        }
    }
}
