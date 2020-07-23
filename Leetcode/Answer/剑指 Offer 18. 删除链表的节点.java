/**
 * 双指针
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
         if(head.val == val) return head.next;
         ListNode pre = head, cur = head.next;
         while(cur != null && cur.val != val) {
             pre = cur;
             cur = cur.next;
         }
         if(cur != null) pre.next = cur.next;
         return head;
     }
 }

 /**
  * 单指针
  */
  class Solution {
 
    public ListNode deleteNode(ListNode head, int val) {
         if(head.val == val) return head.next;
         ListNode  cur = head;
         while(cur.next!= null && cur.next.val != val) {
             cur = cur.next;
         }
         if(cur.next != null) cur.next = cur.next.next;
         return head;
     }
 }