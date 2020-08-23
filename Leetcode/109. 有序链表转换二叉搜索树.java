/**
 * 方法1：分治+找中位数
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return buildBST(head,null);
    }
    public TreeNode buildBST(ListNode left,ListNode right)
    {
        if(left==right) return null;
        ListNode mid = getMedian(left,right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildBST(left,mid);
        root.right = buildBST(mid.next,right);
        return root;
    }
    public ListNode getMedian(ListNode left,ListNode right)
    {
        ListNode fast = left;
        ListNode slow = left;
        while(fast!=right&&fast.next!=right){
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    
}
/**
 * 方法2
 */
class Solution {
    ListNode globalHead;

    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }

    public int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ++ret;
            head = head.next;
        }
        return ret;
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }
}