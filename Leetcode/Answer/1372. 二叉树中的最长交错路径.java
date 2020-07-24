/**
 * 方法1：递归
 */
class Solution {
    private int ans;
        public int longestZigZag(TreeNode root) {
            ans = 0;
            if (root == null) {
                return ans;
            }
            helper(root.left, true, 0);
            helper(root.right, false, 0);
            return ans;
        }
    
        public void helper(TreeNode root, boolean lastLeft, int cur) {
            if (root == null) {
                return;
            }
            cur += 1;
            ans = Math.max(ans, cur);
            if (lastLeft) {
                helper(root.left, true, 0);
                helper(root.right, false, cur);
            } else {
                helper(root.left, true, cur);
                helper(root.right, false, 0);
            }
        }
    }
    /**
     * 方法2：动态规划
     */
    class Solution {
        private int maxPath = 0;
      
        public int longestZigZag(TreeNode root) {
          dfs(root);
          return maxPath;
        }
      
        private int[] dfs(TreeNode root) {
          int[] res = new int[2];
          if (root == null) {
            res[0] = -1;
            res[1] = -1;
           return res;
          }
          int[] left = dfs(root.left);
          int[] right = dfs(root.right);
          res[0] = 1 + left[1];
          res[1] = 1 + right[0];
          maxPath = Math.max(maxPath, Math.max(res[0], res[1]));
          return res;
        }
      }
      