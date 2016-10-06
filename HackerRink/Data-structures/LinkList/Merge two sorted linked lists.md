```C++
#include <climits>
Node* MergeLists(Node *headA, Node* headB)
{
  // This is a "method-only" submission. 
  // You only need to complete this method 
   if(headA == NULL && headB == NULL)
       return NULL;
    Node *head = new Node();
    int valA = headA == NULL ? INT_MAX : headA->data;
    int valB = headB == NULL ? INT_MAX : headB->data;
    if(valA <= valB)
    {
        head = headA;
        headA = headA->next;
    }
    else
    {
        head = headB;
        headB = headB->next;
    }
    head->next = MergeLists(headA,headB);
    return head;
}
```
