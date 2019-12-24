/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode node = new ListNode(-1);
        node.next = head;
        // 采用前插节点的方法进行反转，定义初始位置的前一节点为头节点prev，然后依次在其后插入遍历到的节点
        ListNode prev = node;
        for (int i = 0; i < m - 1; i++) {
            head = head.next;
            prev = prev.next;
        }
        // 定义last为反转链表的尾节点
        ListNode last = head;
        // 定义subHead为反转链表的头节点
        ListNode subHead = last;
        int index = m + 1;
        while (index <= n) {
            // 定义cur为当前需要处理反转的节点
            ListNode cur = last.next;
            prev.next = cur;
            last.next = cur.next;
            cur.next = subHead;
            subHead = prev.next;
            index++;
        }
        return node.next;
    }
}
