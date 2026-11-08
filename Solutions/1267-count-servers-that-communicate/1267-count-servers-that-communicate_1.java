class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        if (m <= 0)
            return 0;
        int n = grid[0].length;

        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    boolean connected = false;

                    for (int k = 0; k < m; k++) {
                        if (k != i && grid[k][j] == 1) {
                            connected = true;
                            break;
                        }
                    }
                    if (connected) {
                        total++;
                    } else { // only count this computer once
                        for (int k = 0; k < n; k++) {
                            if (k != j && grid[i][k] == 1) {
                                connected = true;
                                break;
                            }
                        }
                        if (connected) {
                            total++;
                        }
                    }
                }
            }
        }
        return total;
    }
}