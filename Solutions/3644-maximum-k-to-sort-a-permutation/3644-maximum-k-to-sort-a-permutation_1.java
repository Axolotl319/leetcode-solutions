class Solution {
    public int sortPermutation(int[] nums) {
        // return 0 if already sorted
        boolean isSorted = true;
        // every num in the wrong position will need to be
        // ANDed with some other in some swap
        int andTotal = Integer.MAX_VALUE; // all 1s
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                // wrong position
                andTotal = andTotal & nums[i];
                isSorted = false;
            }
        }
        return isSorted ? 0 : andTotal;
    }
}