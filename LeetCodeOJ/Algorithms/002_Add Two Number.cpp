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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* tmp = new ListNode(0);
		ListNode* p = tmp;
		int carry = 0;

		while (l1 != NULL || l2 != NULL)
		{
			int val1 = 0;
			if (l1 != NULL)
			{
				val1 = l1->val;
				l1 = l1->next;
			}
			int val2 = 0;
			if (l2 != NULL)
			{
				val2 = l2->val;
				l2 = l2->next;
			}
			int sum = val1 + val2 +carry;
			tmp->val =sum % 10;
			carry = sum / 10;
			if (l1 == NULL && l2 == NULL && carry == 0)
				break;
			tmp->next = new ListNode(carry);
			tmp = tmp->next;
		}
		return p;
    }
};
