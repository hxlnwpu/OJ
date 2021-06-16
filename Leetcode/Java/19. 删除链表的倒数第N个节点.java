/**
 * 方法1：两边扫描，计算正向的索引
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode p = head;
        int size = 0;
        while(p!=null)
        {
            size++;
            p = p.next;
        }
        int index = size-n;
        if(index == 0) return head.next;
        ListNode q = head;
        int i = 0;
        while(i<index-1)
        {
            q = q.next;
            i++;
        }
        q.next = q.next.next;
        return head;
    }
}
/**
 * 方法2：快慢指针间隔n
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head,fast= head;
        for(int i = 0;i<=n;i++)
        {
            if(fast==null) return head.next;
            else fast = fast.next;
        }
            
        while(fast!=null)
        {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}