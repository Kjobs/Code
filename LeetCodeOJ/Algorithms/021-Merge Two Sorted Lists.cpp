/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (l1 == NULL) return l2;
        if (l2 == NULL) return l1;
        ListNode *res = NULL;
        ListNode *a = NULL;
        ListNode *p = l1;
        ListNode *q = l2;
        if (p->val < q->val) {
            a = new ListNode(p->val);
            p = p->next;
        }
        else {
            a = new ListNode(q->val);
            q = q->next;
        }
        res = a;
        while (p != NULL && q != NULL) {
            int tmp1 = p->val;
            int tmp2 = q->val;
            if (tmp1 < tmp2) {
                a->next = new ListNode(tmp1);
                a = a->next;
                p = p->next;
            }
            else {
                a->next = new ListNode(tmp2);
                a = a->next;
                q = q->next;
            }
        }
        if (p != NULL){
            a->next = p;
        }
        if (q != NULL) {
            a->next = q;
        }
        return res;
    }
};
