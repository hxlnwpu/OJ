/**
 *方法1：递归交换节点
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }
}
/**
 * 方法2：迭代交换
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
     ListNode dummy = new ListNode(-1);
     dummy.next = head;
     ListNode pre = dummy;
     while((head!=null)&& (head.next!=null))
     {
         ListNode first =head;
         ListNode second = head.next;
         pre.next = second;
         first.next = second.next;
         second.next = first;
         pre = first;
         head = first.next;
     }
     return dummy.next;
 }
}
/**
 * 方法3：只交换值
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;


        ListNode first = head,second = head.next;
        while(second!=null)
        {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
            first= first.next;
            first= first.next;
            if(second.next!=null)
            {
                second = second.next;
                second = second.next;
            }
            else 
                break;

        }
        return head;
    }
}