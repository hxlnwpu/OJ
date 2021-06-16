/**
 * 方法1
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;  // 若head为空则直接返回null
        ListNode dummy = new ListNode(-1);  // 建立一个虚拟头结点
        ListNode tail = dummy;  // 定义一个尾巴，用于尾插法。
        for (ListNode l = head, r = head; l != null; l = r) {
            while (r != null && r.val == l.val) r = r.next;  // 只要r不为空并且与l的值相等则一直向后移动
            if (l.next == r) {  // 若长度为1，则通过尾插法加入。
                tail.next = l;  // 基本的尾插法                                         
                tail = l;                                               
                tail.next = null;  // 这里记得将尾部的后面置为null，不然可能后面会带着一些其他的节点。
            }
        }
        return dummy.next;
    }
}
/**
 * 方法2：重新创建新链表
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
                List<Integer> diffSet = new ArrayList<>();
        List<Integer> sameSet = new ArrayList<>();
        ListNode p = head;
        while(p!=null)
        {
            if(!diffSet.contains(p.val))
                diffSet.add(p.val);
            else
                sameSet.add(p.val);
            p = p.next;
        }
        List<Integer> diff = new ArrayList<>();
        for(int i:diffSet)
            if(!sameSet.contains(i))
                diff.add(i);
        if(diff.size()==0) return null;
            ListNode newlist = new ListNode(diff.get(0));
            ListNode q = newlist;
            for(int i =1;i<diff.size();i++)
            {
                ListNode r = new ListNode(diff.get(i));
                q.next = r;
                q = r;
            }
            return newlist;
    }
}