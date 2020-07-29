class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        HashMap<Node,Node> map = new HashMap<>();
        Node cur  = head;
        Node newHead = new Node(-1);;
        Node pre = newHead;
        while(cur!=null)
        {
            Node node = new Node(cur.val);
            map.put(cur,node);
            pre.next = node;
            pre = node;
            cur = cur.next;
        }
        Node newTemp = newHead.next;
        Node oldTemp = head;
        while(oldTemp!=null)
        {
            newTemp.random = map.get(oldTemp.random);
            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }
        return newHead.next;
    }
}
/**
 * 方法2
 */
class Solution {
    public Node copyRandomList(Node head) {
        cloneNodes(head);
        connectRandom(head);
        Node node = divideList(head);
        return node;
    }
    void cloneNodes(Node head)
    {
        Node cur = head;
        while(cur!=null)
        {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
    }
    void connectRandom(Node head)
    {
        Node cur = head;
        while(cur!=null)
        {
            Node clone = cur.next;
            if(cur.random!=null)
                clone.random = cur.random.next;
            cur = clone.next;
        }
    }
    Node divideList(Node head)
    {
        Node cur = head;
        Node clonedHead = null;
        Node clone = null;
        if(cur!=null)
        {
            clonedHead = clone = cur.next;
            cur.next = clone.next;
            cur = cur.next;
        }
        while(cur!=null)
        {
            clone.next = cur.next;
            clone = clone.next;
            cur.next = clone.next;
            cur = cur.next;
        }
        return clonedHead;
    }
}