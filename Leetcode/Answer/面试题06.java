/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        if(head == null) return new int[0];
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while(p != null)
        {
            stack.push(p.val);
            p = p.next;
        }
        int size = stack.size();
        int[] ret = new int[size];
        for (int i = 0; i <size ; i++) {
            ret[i]=stack.pop();
        }
        return ret;
    }
}