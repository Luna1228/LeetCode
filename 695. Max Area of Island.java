/**
 * created by Luna1228
 * dfs 经典题
 * O(mn)
 * description: https://leetcode.com/problems/max-area-of-island/description/
 */
 
 class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int m = grid.length;
        if(m == 0) return res;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    res  = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }
    
    public int dfs(int[][] grid, int i, int j ){
        if(i == grid.length || j == grid[0].length || i < 0 || j < 0 || grid[i][j] == 0) return 0;
        int res = 1;
        grid[i][j] = 0;
        res += dfs(grid, i-1, j);
        res += dfs(grid, i+1, j);
        res += dfs(grid, i, j-1);
        res += dfs(grid, i, j+1);
        return res;
    }
}
