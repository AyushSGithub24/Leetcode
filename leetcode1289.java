import java.util.Arrays;

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int min = Integer.MAX_VALUE;
        int dp[][] = new int[grid.length][grid[0].length];
        for (int i[] : dp) {
            Arrays.fill(i,-1);
        }
        for (int i = 0; i < grid[0].length; i++) {
            min = Math.min(min, recu(grid, 0, i, dp));
        }
        return min;

    }

    int recu(int[][] m, int i, int j, int dp[][]) {
        if (dp[i][j] != -1)
            return dp[i][j];
        if (i == m.length - 1) {
            return m[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int row = 0; row < m[0].length; row++) {
            if (row != j)
                min = Math.min(min, recu(m, i + 1, row, dp) + m[i][j]);
        }
        dp[i][j] = min;
        return min;
    }
}