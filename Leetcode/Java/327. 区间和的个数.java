/**
 * 方法1：前缀和
 */
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n  = nums.length;
        double[] sum = new double[n+1];
        sum[0] = 0;
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i]+nums[i];
        }
        int ans = 0;
        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j < i; j++) {
                if(sum[i]-sum[j]>=lower&&sum[i]-sum[j]<=upper)
                {
                    ans++;
                }
            }
        }
        return ans;
    }

}