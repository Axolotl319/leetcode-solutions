class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if(n <= 0 || n != labels.length() || k <= 0) return -1;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            visited[i] = false;
        }
        int min = explore(edges, labels, '0', 0, k, 0, visited, 0);
        return min;
    }

    private int explore(int[][] edges, String labels, char last, int numLastChar, int k, int node, boolean[] visited, int weight){
        char c = labels.charAt(node);
        // validity check first
        if(numLastChar == k && last == c || node < 0 || node >= visited.length || visited[node]){
            // unviable path
            return -1;
        }
        visited[node] = true;
        if(node == visited.length-1) return weight;
        // explore all possible paths then backtrack
        if(c == last){
            numLastChar++;
        }else{
            last = c;
            numLastChar = 1;
        }
        int pathSize = Integer.MAX_VALUE;
        boolean validPath = false;
        for(int i = 0; i < edges.length; i++){
            if(edges[i][0] == node){
                int size = explore(edges, labels, last, numLastChar, k, edges[i][1], visited, weight+edges[i][2]);
                if(size != -1) {
                    pathSize = Math.min(pathSize, size);
                    validPath = true;
                }
            }
        }
        return validPath ? pathSize : -1;
    }
}