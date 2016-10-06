```C++
int GetNode(Node *head,int positionFromTail)
{
  // This is a "method-only" submission. 
  // You only need to complete this method.
    Node *p = new Node();
    p = head;
    Node *q = new Node();
    q = head;
    while(positionFromTail != 0)
    {
        q = q->next;
        positionFromTail--;
    }
    while(q->next != NULL)
    {
        p = p->next;
        q = q->next;
    }
    return p->data;
}
```
