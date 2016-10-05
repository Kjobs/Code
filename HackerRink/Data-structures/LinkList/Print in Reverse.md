```C++
#include <stack>
void ReversePrint(Node *head)
{
  // This is a "method-only" submission. 
  // You only need to complete this method. 
    if(head == NULL)
        return;
    int tmp;
    stack<int> s;
    Node *cur = new Node();
    cur = head;
    s.push(cur->data);
    while(cur->next != NULL){
        cur = cur->next;
        s.push(cur->data);
    }
    while(!s.empty()){
        tmp = s.top();
        s.pop();
        cout << tmp << endl;
    }
    
}
```
