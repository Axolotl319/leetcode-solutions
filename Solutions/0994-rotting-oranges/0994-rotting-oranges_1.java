class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int m = grid.length;
        if(m <= 0) return -1;
        int n = grid[0].length;
        // (x, y, n) = at position (x, y) and became rotten at minute n
        Queue<List<Integer>> rottenOranges = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }else if(grid[i][j] == 2){
                    List<Integer> rottenLoc = new ArrayList<>();
                    rottenLoc.add(i); rottenLoc.add(j); rottenLoc.add(0);
                    rottenOranges.add(rottenLoc);
                }
            }
        }
        if(fresh > 0 && rottenOranges.isEmpty()){
            return -1;
        }else if(fresh == 0){
            return 0;
        }

        int minute = 0;
        while(fresh > 0 && !rottenOranges.isEmpty()){
            List<Integer> loc = rottenOranges.poll();
            int i = loc.get(0); int j = loc.get(1);
            int minOfRot = loc.get(2);
            if(i > 0 && grid[i-1][j] == 1){
                grid[i-1][j] = 2;
                List<Integer> next = new ArrayList<>();
                next.add(i-1); next.add(j); next.add(minOfRot+1);
                minute = Math.max(minute, minOfRot+1);
                rottenOranges.add(next);
                fresh--;
            }
            if(j > 0 && grid[i][j-1] == 1){
                grid[i][j-1] = 2;
                List<Integer> next = new ArrayList<>();
                next.add(i); next.add(j-1); next.add(minOfRot+1);
                minute = Math.max(minute, minOfRot+1);
                rottenOranges.add(next);
                fresh--;
            }
            if(i < m-1 && grid[i+1][j] == 1){
                grid[i+1][j] = 2;
                List<Integer> next = new ArrayList<>();
                next.add(i+1); next.add(j); next.add(minOfRot+1);
                minute = Math.max(minute, minOfRot+1);
                rottenOranges.add(next);
                fresh--;
            }
            if(j < n-1 && grid[i][j+1] == 1){
                grid[i][j+1] = 2;
                List<Integer> next = new ArrayList<>();
                next.add(i); next.add(j+1); next.add(minOfRot+1);
                minute = Math.max(minute, minOfRot+1);
                rottenOranges.add(next);
                fresh--;
            }
        }
        return fresh > 0 ? -1 : minute;
    }
}