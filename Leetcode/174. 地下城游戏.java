/**
 * 动态规划
 */
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
          int m = dungeon.length;
         int n = dungeon[0].length;
         int[][] DP = new int[m][n];
         DP[m-1][n-1] = 1;
         for(int i = m -2;i>=0;i--)
             DP[i][n-1] = Math.max(DP[i+1][n-1]-dungeon[i+1][n-1],1);
        for(int i = n -2;i>=0;i--)
            DP[m-1][i] = Math.max(DP[m-1][i+1]-dungeon[m-1][i+1],1);
        for(int i = m-2;i>=0;i--)
            for(int j = n-2;j>=0;j--)
            {
                int right = Math.max(DP[i][j+1]-dungeon[i][j+1],1);
                int down = Math.max(DP[i+1][j]-dungeon[i+1][j],1);
                DP[i][j] = Math.min(right,down);
            }
        return Math.max(DP[0][0] - dungeon[0][0], 1);
    }
}