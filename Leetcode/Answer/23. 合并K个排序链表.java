/**
 * 方法1：两两合并
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       if(lists.length == 0) return null;
        if(lists.length==1) return lists[0];
        for(int i = 0;i<lists.length-1;i++)
        {
            ListNode head = new ListNode(-1);
            ListNode cur = head;
            ListNode l1 = lists[i];
            ListNode l2 = lists[i+1];
            while(l1!=null && l2!=null)
            {
                if(l1.val<=l2.val)
                {
                    cur.next  = l1;
                    l1= l1.next;
                }
                else
                {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            cur.next = l1==null?l2:l1;
            lists[i+1] =  head.next;
        }
        return lists[lists.length-1];
    }
}
/**
 * 方法2：元素全部加到list排序后按照尾插法创建链表
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
                     if(lists.length == 0) return null;
        if(lists.length==1) return lists[0];
        int k = lists.length;
        ListNode head = new ListNode(-1);
        List<Integer> elements = new ArrayList<>();
        for(int i = 0;i<k;i++)
        {
            ListNode cur = lists[i];
            while(cur!=null)
            {
                elements.add(cur.val);
                cur= cur.next;

            }
        }
        Collections.sort(elements);
        ListNode q = head;
        for(int i = 0;i<elements.size();i++)
        {
            ListNode p = new ListNode(elements.get(i));
            q.next = p;
            q = p;
        }
        return head.next;
    }
}
/**
 * 方法3：优先队列
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
         if (lists == null || lists.length == 0) return null;
         PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
             @Override
             public int compare(ListNode o1, ListNode o2) {
                 if (o1.val < o2.val) return -1;
                 else if (o1.val == o2.val) return 0;
                 else return 1;
             }
         });
         ListNode dummy = new ListNode(0);
         ListNode p = dummy;
         for (ListNode node : lists) {
             if (node != null) queue.add(node);
         }
         while (!queue.isEmpty()) {
             p.next = queue.poll();
             p = p.next;
             if (p.next != null) queue.add(p.next);
         }
         return dummy.next;
     }
 }