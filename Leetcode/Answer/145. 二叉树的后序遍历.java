/**
 * 方法1：递归
 */
class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
       if(root==null) return ans;
       traversal(root);
       return ans;
    }
    public void traversal(TreeNode root)
    {
        if(root==null) return;
        traversal(root.left);
        traversal(root.right);
        ans.add(root.val);
    }
}
/**
 * 方法2：迭代
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
      LinkedList<TreeNode> stack = new LinkedList<>();
      LinkedList<Integer> output = new LinkedList<>();
      if (root == null) {
        return output;
      }
      stack.add(root);
      while (!stack.isEmpty()) {
        TreeNode node = stack.pollLast();
        output.addFirst(node.val);
        if (node.left != null) {
          stack.add(node.left);
        }
        if (node.right != null) {
          stack.add(node.right);
        }
      }
      return output;
    }
  }