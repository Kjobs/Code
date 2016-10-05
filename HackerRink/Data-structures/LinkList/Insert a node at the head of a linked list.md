```C++
Node* Insert(Node *head,int data)
{
  // Complete this method
    Node *temp = new Node();
    temp->data = data;
    temp->next = head;
    return temp;
}
```
