/**
 * 方法1：深度优先搜索
 */
class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
         List<String> ans = new ArrayList<>();
         constructPaths(root,"",ans);
         return ans;
    }
    public void constructPaths(TreeNode root,String path,List<String> paths)
    {
        if(root!=null)
        {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(Integer.toString(root.val));
            if(root.left==null&&root.right==null) paths.add(pathSB.toString());
            else
            {
               pathSB.append("->");
               constructPaths(root.left,pathSB.toString(),paths);
                constructPaths(root.right,pathSB.toString(),paths);
            }
        }

    }
    
}
/**
 * 方法2：广度优先搜索
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
       List<String> ans = new ArrayList<>();
       if(root==null) return ans;
       Queue<TreeNode> nodeQueue = new LinkedList<>();
       Queue<String> pathQueue = new LinkedList<>();
       nodeQueue.add(root);
       pathQueue.add(Integer.toString(root.val));
       while(!nodeQueue.isEmpty())
       {
           TreeNode node = nodeQueue.poll();
           String path = pathQueue.poll();
           if(node.left==null&&node.right==null)
               ans.add(path);
           else{
               if(node.left!=null)
               {
                   nodeQueue.add(node.left);
                   pathQueue.add(new StringBuffer(path).append("->").append(node.left.val).toString());
               }
               if(node.right!=null)
               {
                   nodeQueue.add(node.right);
                   pathQueue.add(new StringBuffer(path).append("->").append(node.right.val).toString());
               }
           }
       }
       return ans;
    }
}