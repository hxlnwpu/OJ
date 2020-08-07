/**
 * 方法1
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         ListNode p = headA,q = headB;
         while(p!=null)
         {
             q = headB;
             while(q!=null)
             {
                 if(p!=q)
                     q = q.next;
                 else return q;
             }
             p = p.next;
         }
         return null;
    }
}
/**
 * 方法2
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         ListNode p = headA,q = headB;
         if(p==q) return p;
        LinkedList<ListNode> stacka = new LinkedList<>();
        LinkedList<ListNode> stackb = new LinkedList<>();
        while(p!=null)
         {
             stacka.add(p);
             p = p.next;
         }
        while(q!=null)
        {
           stackb.add(q);
           q = q.next;
        }
        ListNode prev = null;
         int size = Math.min(stacka.size(),stacka.size());
         if(size==1&&stacka.peekLast()==stackb.peekLast())  return stacka.pollLast();
         while(size>=0)
         {
             p = stacka.pollLast();
             q = stackb.pollLast();
             if(p==q)
                 prev = p;
             else
                 return prev;
             size--;
         }
         return prev;
    }
}

/**
 * 方法3
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         ListNode p = headA,q = headB;
         while(p!=q)
         {
             if(p==null)
                 p = headB;
             else
                 p = p.next;
             if(q==null)
                 q = headA;
             else
                 q = q.next;
         }
         return p;
    }
}