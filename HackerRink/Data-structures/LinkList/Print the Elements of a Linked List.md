```C++
void Print(Node *head)
{
  // This is a "method-only" submission. 
  // You only need to complete this method. 
    if(head != NULL){
        cout << head->data << endl;
        Print(head->next);
    }
}
```
