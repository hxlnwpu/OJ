/**
 * 方法1：从上到下递归
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
     if(root==null) return true;
     return Math.abs(depth(root.left)-depth(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
    public int  depth(TreeNode node)
    {
        if(node==null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        return Math.max(left,right)+1;

    }
}
/**
 * 方法2：从下到上递归
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
       return depth(root)>=0;
    }
    public int  depth(TreeNode node)
    {
        if(node==null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        if(left==-1||right==-1||Math.abs(left-right)>1)
            return -1;
        else
            return Math.max(left,right)+1;

    }
}