/*以下两种方法都是建立一个辅助HashMap保存已遍历节点，时间复杂度和空间复杂度都是O(N)*/
/* 递归法 */
class Solution {
    private Map<Node,Node> visitedNode = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        if(head == null) {
            return  null;
        }

        if(this.visitedNode.containsKey(head)) {
            return this.visitedNode.get(head);
        }
        Node node = new Node(head.val);
        visitedNode.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }
}

/* 迭代法 */
class Solution {
    private Map<Node,Node> visitedNode = new HashMap<>();

    private Node getCloneNode(Node node) {
        if (node != null) {
            if (visitedNode.containsKey(node)) {
                return visitedNode.get(node);
            } else {
                visitedNode.put(node, new Node(node.val));
                return visitedNode.get(node);
            }
        }
        return null;
    }

    public Node copyRandomList(Node head) {
        if(head == null) {
            return  null;
        }
        Node oldNode = head;
        Node newNode = new Node(head.val);
        visitedNode.put(oldNode, newNode);
        while (oldNode != null) {
            newNode.next = getCloneNode(oldNode.next);
            newNode.random = getCloneNode(oldNode.random);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return visitedNode.get(head);
    }
}
