Node* SortedInsert(Node *head,int data)
{
    // Complete this function
   // Do not write the main method.
    Node *temp = new Node();
    temp->data = data;
    if(head == NULL)
    {
        temp->prev = NULL;
        temp->next = NULL;
        return temp;
    }
    if(head->data >= data)
    {
        temp->next = head;
        temp->prev = NULL;
        head->prev = temp;
        head = temp;
    }
    else
    {
        Node *node = new Node();
        node = head;
        while(node->next != NULL && node->next->data < data)
            node = node->next;
        temp->prev = node;
        temp->next = node->next;
        if(node->next != NULL)
            node->next->prev = temp;
        node->next = temp;
    }
    return head;
}
