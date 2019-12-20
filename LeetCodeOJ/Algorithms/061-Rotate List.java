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

/* 上面的旋转需要2层循环，便于理解，但时间复杂度较高，为O(n^2)；
 * 以下进行了简化，利用求余省去多余旋转操作，时间复杂度为O(n)
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
        if (num == 0) return node;
        node = rotateListNode(node, nodeSize - num);
        return node;
    }

    private ListNode rotateListNode(ListNode head, int num) {
        ListNode cur = head;
        num--;
        while (num != 0) {
            cur = cur.next;
            num--;
        }
        ListNode tail = cur.next;
        cur.next = null;
        ListNode p = tail;
        while (p.next != null) {
            p = p.next;
        }
        p.next = head;
        return tail;

    }
}
