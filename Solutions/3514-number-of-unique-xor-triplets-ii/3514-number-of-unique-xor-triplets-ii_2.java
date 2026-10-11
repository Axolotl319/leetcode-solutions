class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] xors = new boolean[1500]; // 1 <= nums[i] <= 1500
        for(int i = 0; i < xors.length; i++) xors[i] = false;
        addTriplets(xors, nums, 0, 0, 0);
        int total = 0;
        for(int i = 0; i < xors.length; i++){
            if(xors[i]) total++;
        }
        return total;
    }

    private void addTriplets(boolean[] arr, int[] nums, int i, int j, int k){
        int n = nums.length;
        if(i >= n || j >= n || k >= n){
            return;
        }
        int xor = nums[i] ^ nums[j] ^ nums[k];
        arr[xor] = true;
        addTriplets(arr, nums, i+1, j, k);
        addTriplets(arr, nums, i, j+1, k);
        addTriplets(arr, nums, i, j, k+1);
    }
}