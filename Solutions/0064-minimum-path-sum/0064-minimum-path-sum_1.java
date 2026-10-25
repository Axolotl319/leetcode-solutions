class Solution {
    public int minPathSum(int[][] grid) {
        // precondition: grid is not empty
        // you can only move down or right
        int m = grid.length; int n = grid[0].length;
        int[][] totalCost = new int[m][n];
        // initialize squares that can only be reached
        // by moving directly right or down
        totalCost[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            totalCost[i][0] = totalCost[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < n; i++){
            totalCost[0][i] = totalCost[0][i-1] + grid[0][i];
        }
        // calculate for others
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                totalCost[i][j] = grid[i][j] + Math.min(totalCost[i-1][j], totalCost[i][j-1]);
            }
        }
        return totalCost[m-1][n-1];
    }
}