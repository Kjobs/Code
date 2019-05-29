class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if (head == NULL) return NULL;
        unsigned int listLen = 0;
        ListNode *p = head;
        while (head != NULL) {
            listLen++;
            head = head->next;
        }
        if (listLen < n) { return NULL; }
        if (listLen == n) { return p->next; }
        head = p;
        for (int i = 0; i < listLen - n - 1; i++) {
            head = head->next;
        }
        head->next = head->next->next;
        return p;
    }
};
