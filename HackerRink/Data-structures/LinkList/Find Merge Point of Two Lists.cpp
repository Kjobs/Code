int GetLength(Node *head)
{
    int len = 0;
    while(head != NULL)
   {
       len++;
       head = head->next;
    }
    return len;
}
int FindMergeNode(Node *headA, Node *headB)
{
    // Complete this function
    // Do not write the main method. 
    int lenA = GetLength(headA);
    int lenB = GetLength(headB);
    if(lenA < lenB)
        return FindMergeNode(headB,headA);
    
    for(int i=lenA-lenB; i>0; --i)
        headA = headA->next;
    
    while(headA != NULL)
    {
        if(headA == headB)
            return headA->data;
        headA = headA->next;
        headB = headB->next;
    }
    return NULL;
}
