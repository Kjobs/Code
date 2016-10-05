```C++
#include <stack>
Node* Reverse(Node *head)
{
  // Complete this method
    int temp = 0;
    
    if(head == NULL)
        return head;
    
    stack<int> s;
    Node *cur = new Node();
    cur = head;
    s.push(cur->data);
    while(cur->next != NULL)
    {
        cur = cur->next;
        s.push(cur->data);
    }
    
    head = NULL;
    head = new Node();
    temp = s.top();
    s.pop();
    head->data = temp;
    head->next = NULL;
    Node *node = new Node();
    node = head;
    while(!s.empty())
    {
        Node *tmp = new Node();
        temp = s.top();
        s.pop();
        tmp->data = temp;
        tmp->next = NULL;
        node->next = tmp;
        node = node->next;
    }
    return head;
}
```
