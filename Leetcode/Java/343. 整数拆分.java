/**
 * 方法1：数学公式
 */
class Solution {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            return (int) Math.pow(3, quotient) * 2;
        }
    }
}
/**
 * 方法2：动态规划
 */

class Solution {
    public int integerBreak(int n) {
       int[] dp = new int[n+1];
       dp[0]=dp[1]=0;
       for(int i =2;i<=n;i++)
       {
           int curmax = 0;
           for(int j=1;j<i;j++)
               curmax = Math.max(curmax,Math.max(j*(i-j),j*dp[i-j]));
           dp[i] = curmax;
       }
       return dp[n];
    }
}
/**
 * 方法3：优化的动态规划
 */
class Solution {
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
        }
        return dp[n];
    }
}
