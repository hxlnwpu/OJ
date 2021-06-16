public class Solution {
    public ListNode detectCycle(ListNode head) {
       //通过快慢指针先判断有没有环
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
        if(!cycle) return null;
        ListNode p = fast.next;
        //如果有环，计算环的长度
        int n = 1;
        while(p!=fast)
        {
            p = p.next;
            n++;
        }
        ListNode p1 = head,p2 =head;
        for(int i = 0;i<n;i++)
            p1= p1.next;
        while(p1!=p2)
        {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}