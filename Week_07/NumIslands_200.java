package Week_07;

/**
 * Created by xutao on 2020/7/1.
 */
public class NumIslands_200 {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid,i,j);
                    sum++;
                }
            }
        }

        return sum;
    }

    private void dfs(char[][] grid, int row, int col) {
        //terminator
        if(row < 0 || row > grid.length || col < 0 || col > grid[0].length || grid[row][col] == '0') {
            return;
        }
        //process current logic    drill down
        grid[row][col] = '0';
        dfs(grid,row - 1,col);
        dfs(grid,row + 1,col);
        dfs(grid,row,col + 1);
        dfs(grid,row,col - 1);
    }
}
