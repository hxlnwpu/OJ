class Solution {
    Node pre, head; //pre记录双向链表的前一个节点，head为头节点
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        if(cur == null) return;   //cur是当前树的根节点
        dfs(cur.left);  //中序遍历左子树
        if(pre != null) pre.right = cur;  //如果pre=null,就说明cur是最早的根节点
        else head = cur;  
        cur.left = pre;    //串联左子树->根->右子树
        pre = cur;        
        dfs(cur.right);
    }
}