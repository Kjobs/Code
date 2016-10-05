```C++
int CompareLists(Node *headA, Node* headB)
{
    Node *nodeA = new Node();
    nodeA = headA;
    Node *nodeB = new Node();
    nodeB = headB;
    while(nodeA !=NULL && nodeB != NULL)
   {
        if(nodeA->data != nodeB->data)
            return false;
        nodeA = nodeA->next;
        nodeB = nodeB->next;
    }
    if(nodeA == NULL && nodeB == NULL)
        return true;
    if(nodeA == NULL || nodeB == NULL)
        return false;
    return true;
}
```
