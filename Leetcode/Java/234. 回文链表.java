class Solution {
    public boolean isPalindrome(ListNode head) {
           if(head==null) return true;
        ListNode slow = endOfFirstHalf(head);
        ListNode mid = reverseList(slow.next);
        ListNode p1 = head;
        ListNode p2 = mid;
        boolean result = true;
        while(result&&p2!=null)
        {
            if(p1.val!=p2.val) result = false;
            p1 = p1.next;
            p2= p2.next;
        }
        slow.next = reverseList(mid);
        return result;
    }
    private ListNode reverseList(ListNode head)
    {
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null)
        {
            ListNode node = cur.next;
            cur.next = prev;
            prev = cur;
            cur = node;
        }
        return prev;

    }
    private ListNode endOfFirstHalf(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}