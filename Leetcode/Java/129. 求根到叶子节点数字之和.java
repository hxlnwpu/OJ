/**
 * 方法1：深度优先搜索
 */
class Solution {
    public int sumNumbers(TreeNode root) {
       return dfs(root,0);
    }
    public int dfs(TreeNode root,int prevSum)
    {
        if(root==null) return 0;
        int sum = prevSum*10+root.val;
        if(root.left==null&&root.right==null)
        {
            return sum;
        }
        else 
            return dfs(root.left,sum)+dfs(root.right,sum);
        
    }
}
/**
 * 广度优先搜索
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> numQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }
}
