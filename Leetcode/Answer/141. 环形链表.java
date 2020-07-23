public class Solution {
    public boolean hasCycle(ListNode head) {
        //通过快慢指针判断有没有环
        ListNode slow = head,fast = head;
        boolean cycle = false;
        while(fast!=null&&fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
            if(fast == slow)
            {
              cycle = true;
              break;
            } 
        }
        return cycle;
    }
}