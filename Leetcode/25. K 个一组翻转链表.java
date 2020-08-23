/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;
        ListNode hair = pre;
        ListNode tail = pre;
        ListNode start,next;
        while(tail.next!=null)
        {
            for(int i =0;i<k&&tail!=null;i++)
            {
                tail = tail.next;
            }
            if(tail==null)
                break;
            next = tail.next;
            start = pre.next;
            tail.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            tail = pre;
        }
        return hair.next;
    }
    //翻转链表
    private ListNode reverse(ListNode head)
    {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null)
        {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}