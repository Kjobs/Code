```C++
Node* Delete(Node *head, int position)
{
  // Complete this method
    int count = 0;
    if(head == NULL)
        return head;
    else if(position == 0)
        head = head->next;
    else
    {
        Node *cur = new Node();
        cur = head;
        while(count != position-1)
        {
            count += 1;
            cur = cur->next;
        }
        cur->next = cur->next->next;
    }
    return head;
}
```
