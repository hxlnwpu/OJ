/**
 * 方法1：双指针
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode cur = head,pre = head;
        while(cur != null)
        {
            if(!set.contains(cur.val))
            {
                set.add(cur.val);
                pre = cur;
                cur = cur.next;
            }
            else
            {
                pre.next = cur.next;
                cur = cur.next;
            }
        }
        return head;
    }
}
/**
 * 方法2：直接比较当前值和下一个值
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    while (current != null && current.next != null) {
        if (current.next.val == current.val) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
    return head;
}
}