Node* SortedInsert(Node *head,int data)
{
    // Complete this function
   // Do not write the main method. 
    if(head == NULL)
    {
        Node *temp = new Node();
        temp->data = data;
        temp->prev = temp->next = NULL;
        head = temp;
        return head;
    }
    Node *node = head;
    while(node != NULL)
    {
        if(data <= node->data)
       {
           Node *p = new Node();
           p->data = data;
           p->prev = node->prev;
           p->next = node;
           node->prev = p;
           if(p->prev == NULL)
               return p;
           else
           {
               p->prev->next = p;
               return head;
           }
           if(node->next == NULL)
           {
              Node *q = new Node();
              q->data = data;
              q->prev = node;
              q->next = NULL;
              node->next = q;
              break;
           }
        }
        node = node->next;
    }
    return head;
}
