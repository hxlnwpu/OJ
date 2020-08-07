/**
 * 方法1
 */
class Solution {
    public int rob(TreeNode root) {
      if(root==null) return 0;
      int money = root.val;
      if(root.left!=null)
      {
          money+= (rob(root.left.left)+rob(root.left.right));
      }
      if(root.right!=null)
      {
          money+=(rob(root.right.left)+rob(root.right.right));
      }
      return Math.max(money,rob(root.left)+rob(root.right));
    }
}
/**
 * 方法2：记忆化的动态规划
 */
class Solution {
    HashMap<TreeNode,Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
    return robInternal(root);  
      
    }
    public int robInternal(TreeNode node)
    {
        if(node==null) return 0;
        if(memo.containsKey(node)) return memo.get(node);
        int money = node.val;
        if(node.left!=null)
        {
            money+=(robInternal(node.left.left)+robInternal(node.left.right));
        }
        if(node.right!=null)
            money+=(robInternal(node.right.left)+robInternal(node.right.right));
        int result = Math.max(money,robInternal(node.left)+robInternal(node.right));
        memo.put(node,result);
        return result;
    }
}
/**
 * 方法3
 */
class Solution {
    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }
}

