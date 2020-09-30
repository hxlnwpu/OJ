/**
 * 方法1：深度优先
 */
class Solution {
    private static int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        return root!=null?dfs(root):0;
    }
    private static int dfs(TreeNode node)
    {
         int ans = 0;
         if(node.left !=null)
             ans += isLeaf(node.left)?node.left.val:dfs(node.left);
         if(node.right!=null&&!isLeaf(node.right))
             ans += dfs(node.right);
         return ans;
    }
    private static boolean isLeaf(TreeNode node)
    {
        return node.left==null&&node.right==null;
    }
}
/**
 * 广度优先
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    ans += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null) {
                if (!isLeafNode(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }
    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}