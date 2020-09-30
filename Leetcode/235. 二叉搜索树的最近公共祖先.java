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
/**
 * 方法3：
 */
class Solution {
    /**
     * 路径的分叉点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      List<TreeNode> path_p = getPath(root,p);
      List<TreeNode> path_q = getPath(root,q);
      TreeNode ancestor = null;
        for (int i = 0; i < path_p.size()&&i<path_q.size(); i++) {
            if(path_p.get(i)==path_q.get(i))
                ancestor = path_p.get(i);
            else
                break;
        }
        return ancestor;
      
    }
    /**
     * 找p和q的路径
     * @param root
     * @param target
     * @return
     */
    public List<TreeNode> getPath(TreeNode root,TreeNode target)
    {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while(node!=target)
        {
            path.add(node);
            if(target.val<node.val)
                node = node.left;
            else
                node = node.right;
        }
        path.add(node);
        return path;
    }
}
/**
 * 方法4：1次遍历
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }
}