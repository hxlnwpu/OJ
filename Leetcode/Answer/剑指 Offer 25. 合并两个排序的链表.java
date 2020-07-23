class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1==null&&l2==null) return null;
                   ListNode p1 = l1;
           ListNode p2 = l2;
           ListNode cur = new ListNode(-1);
           ListNode ans = cur;
           while(p1!=null && p2!=null)
           {
               if(p1.val<=p2.val)
               {
                   cur.next = p1;
                   p1= p1.next;
               }
               else
               {
                   cur.next = p2;
                   p2 = p2.next;
               }
               cur =cur.next;
           }
           if(p1!=null)
           {
               while(p1!=null)
               {
                   cur.next = p1;
                   p1 = p1.next;
                   cur = cur.next;
               }
           }
           else if(p2!=null)
          {
            while(p2!=null)
            {
                cur.next = p2;
                p2 = p2.next;
                cur = cur.next;
            }
        }
           return ans.next;
    }
}
/**
 * 简洁版
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }
}