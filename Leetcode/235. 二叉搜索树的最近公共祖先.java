/**
 * 方法1：递归
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         int parentvalue = root.val;
         int pval = p.val;
         int qval = q.val;
         if(pval>parentvalue&&qval>parentvalue)
             return lowestCommonAncestor(root.right,p,q);
         else if(pval<parentvalue&&qval<parentvalue)
             return lowestCommonAncestor(root.left,p,q);
         else
             return root;
    }
}
/**
 * 方法2：迭代
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        // Start from the root node of the tree
        TreeNode node = root;

        // Traverse the tree
        while (node != null) {

            // Value of ancestor/parent node.
            int parentVal = node.val;

            if (pVal > parentVal && qVal > parentVal) {
                // If both p and q are greater than parent
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // If both p and q are lesser than parent
                node = node.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return node;
            }
        }
        return null;
    }
}
