/**
 * 方法1：动态规划
 */
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = 0;
        int min = prices[0];
        for(int i = 1;i<n;i++)
        {
            if(prices[i]<min) min = prices[i];
            dp[i] = Math.max(dp[i-1],prices[i]-min);
        }
        return dp[n-1];
    }
}
/**
 * 优化后的动态规划
 */
class Solution {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
/**
 * 方法2：暴力
 */
class Solution {

    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for(int i =0;i<n-1;i++)
            for(int j = i+1;j<n;j++)
            {
                if(prices[j]>prices[i])
                    ans = Math.max(ans, prices[j]-prices[i]);
            }
        return ans;
    }
}