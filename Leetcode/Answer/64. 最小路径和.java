/**
 * 方法1
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int row = grid.length-1;row>=0;row--)
            for(int col = grid[0].length-1;col>=0;col--)
            {
                if(row == (grid.length-1) && col != grid[0].length-1)
                    dp[row][col] = grid[row][col] + dp[row][col+1];
                else if(col == grid[0].length-1 && row != (grid.length-1))
                    dp[row][col] = grid[row][col] + dp[row+1][col];
                else if(row != (grid.length-1) && col != grid[0].length-1)
                    dp[row][col] = grid[row][col] + Math.min(dp[row+1][col],dp[row][col+1]);
                else
                    dp[row][col] = grid[row][col];
            }
        return dp[0][0];
    }
}
/**
 * 方法2
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for(int row = grid.length-1;row>=0;row--)
            for(int col = grid[0].length-1;col>=0;col--)
            {
                if(row == (grid.length-1) && col != grid[0].length-1)
                    dp[col] = grid[row][col] + dp[col+1];
                else if(col == grid[0].length-1 && row != (grid.length-1))
                    dp[col] = grid[row][col] + dp[col];
                else if(row != (grid.length-1) && col != grid[0].length-1)
                    dp[col] = grid[row][col] + Math.min(dp[col],dp[col+1]);
                else
                    dp[col] = grid[row][col];
            }
        return dp[0];
    }
}
/**
 * 方法3
 */
class Solution {
    public int minPathSum(int[][] grid) {
        for(int row = grid.length-1;row>=0;row--)
            for(int col = grid[0].length-1;col>=0;col--)
            {
                if(row == (grid.length-1) && col != grid[0].length-1)
                    grid[row][col] = grid[row][col] + grid[row][col+1];
                else if(col == grid[0].length-1 && row != (grid.length-1))
                    grid[row][col] = grid[row][col] + grid[row+1][col];
                else if(row != (grid.length-1) && col != grid[0].length-1)
                    grid[row][col] = grid[row][col] + Math.min(grid[row+1][col],grid[row][col+1]);
                else
                    grid[row][col] = grid[row][col];
            }
        return grid[0][0];
    }
}