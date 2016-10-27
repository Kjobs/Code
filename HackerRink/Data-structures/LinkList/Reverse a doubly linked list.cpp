Node* Reverse(Node* head)
{
    // Complete this function
    // Do not write the main method.
    if(head == NULL || head->next == NULL)
        return head;
    Node *node = head;
    Node *temp = new Node();
    while(node != NULL)
    {
        temp->next = node->next;
        temp->prev = node->prev;
        node->next = temp->prev;
        node->prev = temp->next;
        node = temp->next;
        if(node != NULL)
            head = node;
    } 
    return head;
}
