class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null)
            queue.add(root);
        while(!queue.isEmpty())
        {
            List<Integer> tmp = new ArrayList<>();
            int n = queue.size();
            for(int i =0;i<n;i++)
            {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            res.addFirst(tmp);
        }
        return res;
    }
}