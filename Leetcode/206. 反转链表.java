/**
 * 方法1
 */
class Solution {
    public ListNode reverseList(ListNode head) {
         ListNode cur = head;
           ListNode pre = null;
           ListNode reverse = head;
           while(cur!=null)
           {
               ListNode next = cur.next;
               if(next==null) reverse = cur;
               cur.next = pre;
               pre = cur;
               cur = next;
           }
           return reverse;
    }
}
