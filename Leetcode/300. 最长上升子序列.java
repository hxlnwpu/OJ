/**
 * 方法1:动态规划
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
       if(nums==null||nums.length==0) return 0;
       int maxAns = 1;
       int[] dp = new int[nums.length];
       dp[0]=1;
      
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j <nums.length ; j++) {
                if(nums[i]>nums[j])
                    maxval = Math.max(dp[j],maxval);
            }
            dp[i] = maxval+1;
            maxAns = Math.max(maxAns,dp[i]);
        }
        return maxAns;
    }
}
/**
 * 方法2：贪心+二分查找
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }
}
