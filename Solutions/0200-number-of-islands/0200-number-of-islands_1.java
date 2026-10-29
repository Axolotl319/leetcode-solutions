class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        int islands = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                visited[i][j] = false;
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                islands += explore(grid, visited, i, j);
            }
        }
        return islands;
    }

    private int explore(char[][] grid, boolean[][] visited, int i, int j){
        if(visited[i][j]) return 0;
        visited[i][j] = true;
        if(grid[i][j] == '0') return 0; // stop at water
        // mark all that are part of the island as visited
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int[] direction: directions){
            int x = i + direction[0];
            int y = j + direction[1];
            if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length){
                explore(grid, visited, x, y);
            }
        }
        return 1; // island found
    }
}