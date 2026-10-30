class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if(n <= 0 || n != labels.length() || k <= 0) return -1;
        int min = explore(edges, labels, '0', 0, k, 0, n, 0);
        return min;
    }

    private int explore(int[][] edges, String labels, char last, int numLastChar, int k, int node, int n, int weight){
        char c = labels.charAt(node);
        // validity check first
        if(numLastChar == k && last == c || node < 0 || node >= n){
            // unviable path
            return -1;
        }
        if(node == n-1) return weight;
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
                int size = explore(edges, labels, last, numLastChar, k, edges[i][1], n, weight+edges[i][2]);
                if(size != -1) {
                    pathSize = Math.min(pathSize, size);
                    validPath = true;
                }
            }
        }
        return validPath ? pathSize : -1;
    }
}