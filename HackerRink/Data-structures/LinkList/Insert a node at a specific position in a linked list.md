```C++
Node* InsertNth(Node *head, int data, int position)
{
  // Complete this method only
  // Do not write main function.
    int count = 0;
   if(head == NULL || position == 0)
   {
       Node *temp = new Node();
       temp->data = data;
       temp->next = head;
       return temp;
   }
   else
   {
       Node *cur = new Node();
       Node *tmp = new Node();
       cur = head;
       while(count != position-1){
           count += 1;
           cur = cur->next;
       }
       tmp->data = data;
       tmp->next = cur->next;
       cur->next = tmp;
   }
    return head;
}
```
