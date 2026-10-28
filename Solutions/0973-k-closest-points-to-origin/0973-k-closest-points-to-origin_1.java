class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // sqdist[i] is the square distance of points[i] from 0
        int n = points.length;
        if(k >= n) return points;
        int[] sqdist = new int[n]; 
        int[] sqdistSorted = new int[n];
        for(int i = 0; i < n; i++){
            int[] point = points[i];
            sqdist[i] = point[0]*point[0] + point[1]*point[1];
            sqdistSorted[i] = sqdist[i];
        }
        Arrays.sort(sqdistSorted);
        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++){
            int j = 0;
            while(sqdistSorted[i] != sqdist[j]) j++;
            sqdist[j] = -1; // don't count twice
            result[i] = points[j];
        }
        return result;
    }
}