/**
 * 方法1：递归
 */
class Solution {
    List<Integer> ans = new ArrayList<>();
     public List<Integer> preorderTraversal(TreeNode root) {
            if(root==null) return ans;
            traversal(root);
            return ans;
     }
     public void traversal(TreeNode root) {
            if(root==null) return;
            ans.add(root.val);
            traversal(root.left);
            traversal(root.right);
     }
 }
 /**
  * 方法2：利用栈模拟递归
  */
  class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
      LinkedList<TreeNode> stack = new LinkedList<>();
      LinkedList<Integer> output = new LinkedList<>();
      if (root == null) {
        return output;
      }
      stack.add(root);
      while (!stack.isEmpty()) {
        TreeNode node = stack.pollLast();
        output.add(node.val);
        if (node.right != null) {
          stack.add(node.right);
        }
        if (node.left != null) {
          stack.add(node.left);
        }
      }
      return output;
    }
  }
  /**
   * 方法3：莫里斯遍历
   */
  class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
      LinkedList<Integer> output = new LinkedList<>();
  
      TreeNode node = root;
      while (node != null) {
        if (node.left == null) {
          output.add(node.val);
          node = node.right;
        }
        else {
          TreeNode predecessor = node.left;
          while ((predecessor.right != null) && (predecessor.right != node)) {
            predecessor = predecessor.right;
          }
  
          if (predecessor.right == null) {
            output.add(node.val);
            predecessor.right = node;
            node = node.left;
          }
          else{
            predecessor.right = null;
            node = node.right;
          }
        }
      }
      return output;
    }
  }
