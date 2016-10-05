```C++
Node* Insert(Node *head,int data)
{
  // Complete this method
    Node *temp = new Node;
    temp->data = data;
    temp->next = NULL;
    if(head == NULL)
        head = temp;
    else
    {
        Node *cur = new Node;
        cur = head;
        while(cur->next != NULL)
            cur = cur->next;
        cur->next = temp;
    }
    return head;
}
```
