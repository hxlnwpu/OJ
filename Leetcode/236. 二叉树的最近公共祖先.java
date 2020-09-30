/**
 * 方法1
 */
class Solution {
    Map<Integer,TreeNode> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while(p!=null)
        {
            set.add(p.val);
            p = map.get(p.val);
        }
        while(q!=null)
        {
            if(set.contains(q.val))
                return q;
            q = map.get(q.val);
        }
        return null;
    }
    public void dfs(TreeNode root)
    {
        if(root.left!=null)
        {
            map.put(root.left.val, root);
            dfs(root.left);
        }
        if(root.right!=null)
        {
            map.put(root.right.val,root);
            dfs(root.right);
        }
    }

}
/**
 * 方法2
 */
class Solution {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return ans;
    }
    private boolean dfs(TreeNode root,TreeNode p,TreeNode q)
    {
        if(root==null) return false;
        boolean lson = dfs(root.left,p,q);
        boolean rson = dfs(root.right,p,q);
        if((lson&&rson)||((root.val==p.val||root.val==q.val)&&(lson||rson)))
            ans = root;
        return lson||rson ||(root.val==q.val||root.val==p.val);
    }
}