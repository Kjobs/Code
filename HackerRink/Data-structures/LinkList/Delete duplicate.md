```C++
Node* RemoveDuplicates(Node *head)
{
  // This is a "method-only" submission. 
  // You only need to complete this method. 
    if(head == NULL)
        return NULL;
    Node *temp = new Node();
    temp = head;
    Node *cur = new Node();
    for(cur = head->next;cur;cur = cur->next)
    {
        if(cur->data == temp->data)
           temp->next = cur->next;
        else
            temp = cur;
    }
    return head;
}
```
