/**
 * 方法1：动态规划
 */

class Solution {
    public int translateNum(int num) {
        String n = Integer.toString(num);
        int[] dp = new int[n.length()+1];
        dp[0] = 1;
        dp[1] =1;
       for(int i = 2;i<=n.length();i++)
       {
           String tmp = n.substring(i-2,i);
           if(tmp.compareTo("25")<=0&&tmp.compareTo("10")>=0)
               dp[i] = dp[i-1]+dp[i-2];
           else
               dp[i] = dp[i-1];
       }
       return dp[n.length()];
    }
}
/**
 * 优化后的动态规划
 */
class Solution {
    public int translateNum(int num) {
        String n = Integer.toString(num);
        int a = 1;
        int b = 1;
        for(int i = 2;i<=n.length();i++)
        {
            String tmp = n.substring(i-2,i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b =a;
            a = c;

        }
        return a;
    }
}