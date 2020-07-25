/**
 * 方法1：动态规划
 */
class Solution {
    public int cuttingRope(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int[] DP = new int[n+1];
        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 3;
        for(int i = 4;i<=n;i++)
        {
            int max = 0;
            for(int j = 1;j<=i/2;j++)
            {
                int temp = DP[i-j]*DP[j];
                max= Math.max(max,temp);
            }
            DP[i] = max;
        }
        return DP[n];
    }
}
/**
 * 方法2：贪婪算法
 */
class Solution {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }
}
