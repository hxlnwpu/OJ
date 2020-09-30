/**
 * 方法1：递归
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int postIndex;
    int[] postorder;
    int[] inorder;
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        postIndex = postorder.length - 1;
        int index = 0;
        for (Integer i : inorder) {
            map.put(i, index++);
        }
        return helper(0,inorder.length-1);
    }
    public TreeNode helper(int left,int right)
    {
        if(left>right) return null;
        int root_val = postorder[postIndex];
        TreeNode root = new TreeNode(root_val);
        int index = map.get(root.val);
        postIndex--;
        root.right = helper(index+1,right);
        root.left = helper(left,index-1);
        return root;
    }
}