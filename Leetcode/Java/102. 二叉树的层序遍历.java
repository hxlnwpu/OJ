class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> res = new ArrayList<>();
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
           res.add(tmp);
       }
       return res;
    }
}