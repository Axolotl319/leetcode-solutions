class Solution {
    public int sumSubarrayMins(int[] arr) {
        long total = 0;
        for(int i = 0; i < arr.length; i++){
            int min = arr[i];
            for(int j = i; j < arr.length; j++){
                min = Math.min(min, arr[j]);
                total += min;
            }
        }
        //int answer = total % (10^9 + 7L);
        return (int) total;
    }
}