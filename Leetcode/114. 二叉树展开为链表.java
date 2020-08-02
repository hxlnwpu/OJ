class Solution {
    public void flatten(TreeNode root) {
         List<TreeNode> list = new ArrayList<>();
         if(root==null) return;
         preOrder(root,list);
         TreeNode cur = list.get(0);
         TreeNode pre = cur;
         for(int i =1;i<list.size();i++)
         {
             cur = list.get(i);
             pre.left = null;
             pre.right = cur;
             pre = cur;
         }
     }
     void preOrder(TreeNode node,List<TreeNode> list) {
         if(node==null) return;
         list.add(node);
         preOrder(node.left,list);
         preOrder(node.right,list);
     }
 }
 /**
  * 方法2：
  */
  class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }
            TreeNode left = curr.left, right = curr.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            prev = curr;
        }
    }
}
/**
 * 方法3：
 */
class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}
