class Solution {
    public int[] levelOrder(TreeNode root) {
       if(root==null) return new int[0];
        List<Integer> ret = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode node = queue.pollFirst();
            ret.add(node.val);
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
        int[] ans = new int[ret.size()];
        int index =0;
        for(Integer i :ret)
            ans[index++] = i;
        return ans;
    }
}