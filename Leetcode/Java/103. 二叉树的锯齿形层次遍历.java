/**
 * 方法1：分奇偶翻转每一层遍历结果
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root!=null)
        queue.add(root);
        int direct = 1;
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (direct < 0) Collections.reverse(tmp);
            res.add(tmp);
            direct = -direct;
        }
        return res;
    }
}