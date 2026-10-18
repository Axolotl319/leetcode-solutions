class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        if(n < 1) return 0;
        long[] dpA = new long[n];
        long[] dpB = new long[n];
        dpA[0] = energyDrinkA[0];
        dpB[0] = energyDrinkB[0];
        boost(energyDrinkA, energyDrinkB, dpA, dpB, 1);
        return Math.max(dpA[n-1], dpB[n-1]);
    }

    // hint: define dpA[i] as the max energy boost if we consider only the first i+1 hours
    // such that in the last hour we drink the energy drink A
    private void boost(int[] a, int[] b, long[] dpA, long[] dpB, int i){
        if(i >= a.length) return;
        dpA[i] = Math.max(a[i] + dpA[i-1], dpB[i-1]);
        dpB[i] = Math.max(b[i] + dpB[i-1], dpA[i-1]);
        boost(a, b, dpA, dpB, i+1);
    }
}