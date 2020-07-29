/**
 * 递归 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
         if(root==null) return ans;
         dfs(root,sum);
         return ans;

    }
    void dfs(TreeNode node,int tar)
    {
        if(node==null) return;
        path.add(node.val);
        tar -= node.val;
        if(node.left==null&&node.right==null&&tar==0)
        {
            ans.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        dfs(node.left,tar);
        dfs(node.right,tar);
        path.removeLast();
    }
}