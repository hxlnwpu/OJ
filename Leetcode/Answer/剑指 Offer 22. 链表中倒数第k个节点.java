/**
 * 快慢指针
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null || k<1) return null;
        ListNode slow = head;
        ListNode fast = head;
        for(int i =0;i<k;i++)
            fast = fast.next;
        while(fast!=null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}