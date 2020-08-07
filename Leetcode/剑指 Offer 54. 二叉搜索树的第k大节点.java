/**
 * 方法1
 */
class Solution {
    List<Integer> ans = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        if(root==null) return 0;
        traverse(root);
        Collections.sort(ans);
        return ans.get(ans.size()-k);
    }
    void traverse(TreeNode node)
    {
        if(node==null) return;
        ans.add(node.val);
        traverse(node.left);
        traverse(node.right);
    }
}
/**
 * 方法2：二叉树的中序遍历为递增序列
 */
class Solution {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }
}
