class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root==null) return ret;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int num = 1;
        while(!queue.isEmpty())
        {

            Deque<Integer> level = new LinkedList<>();
            int n = queue.size();
            for(int i =0;i<n;i++)
            {
                TreeNode node = queue.poll();
                if(num%2==1)
                level.add(node.val);
                else
                    level.addFirst(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);

            }
            num++;
            List<Integer> temp = new ArrayList<>();
            for(Integer e:level)
                temp.add(e);
            ret.add(temp);
        }
        return ret;
    }
}

/**
 * 方法2
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(res.size() % 2 == 1) Collections.reverse(tmp);
            res.add(tmp);
        }
        return res;
    }
}