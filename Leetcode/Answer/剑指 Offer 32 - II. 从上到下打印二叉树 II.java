/**
 * 算法流程：
特例处理： 当根节点为空，则返回空列表 [] ；
初始化： 打印结果列表 res = [] ，包含根节点的队列 queue = [root] ；
BFS 循环： 当队列 queue 为空时跳出；
    新建一个临时列表 tmp ，用于存储当前层打印结果；
    当前层打印循环： 循环次数为当前层节点数（即队列 queue 长度）；
        出队： 队首元素出队，记为 node；
        打印： 将 node.val 添加至 tmp 尾部；
        添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue ；
    将当前层结果 tmp 添加入 res 。
返回值： 返回打印结果列表 res 即可。
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root==null) return ret;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {

            List<Integer> level = new ArrayList<>();
            int n = queue.size();
            for(int i =0;i<n;i++)
            {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
          
                
            }
            ret.add(level);
        }
        return ret;
    }
}