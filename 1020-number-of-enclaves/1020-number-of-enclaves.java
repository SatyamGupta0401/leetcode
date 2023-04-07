 class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            if(grid[i][0]==1 && !vis[i][0])
            {
                dfs(i,0,m,n,grid,vis);
            }
             if(grid[i][n-1]==1 && !vis[i][n-1])
            {
                dfs(i,n-1,m,n,grid,vis);
            }
        }
        for (int i = 0; i < n; i++) {
            // First row.
            if (grid[0][i] == 1 && !vis[0][i]) {
                dfs(0, i, m, n, grid, vis);
            }
            // Last row.
            if (grid[m - 1][i] == 1 && !vis[m - 1][i]) {
                dfs(m - 1, i, m, n, grid, vis);
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
      public void dfs(int x, int y, int m, int n, int[][] grid, boolean[][] vis) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || vis[x][y]) {
            return;
        }

        vis[x][y] = true;
        int[] dirx = {0, 1, 0, -1};
        int[] diry = {-1, 0, 1, 0};

        for (int i = 0; i < 4; i++) {
            dfs(x + dirx[i], y + diry[i], m, n, grid, vis);
        }
    }
     
}