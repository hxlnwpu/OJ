/**
 * 方法1：递归
 */
class Solution {
    public int maxDepth(TreeNode root) {
            int ans = depth(root);
            return ans;
    }
    public int depth(TreeNode node)
    {
        if(node==null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        return Math.max(L,R)+1;
    }
}
/**
 * 方法2：迭代
 */
class Solution {
  public int maxDepth(TreeNode root) {
    Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
    if (root != null) {
      stack.add(new Pair(root, 1));
    }

    int depth = 0;
    while (!stack.isEmpty()) {
      Pair<TreeNode, Integer> current = stack.poll();
      root = current.getKey();
      int current_depth = current.getValue();
      if (root != null) {
        depth = Math.max(depth, current_depth);
        stack.add(new Pair(root.left, current_depth + 1));
        stack.add(new Pair(root.right, current_depth + 1));
      }
    }
    return depth;
  }
};
