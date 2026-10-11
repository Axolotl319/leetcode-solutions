class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int i = 0; int j = 0; int k = 0;
        Set<Integer> xors = new HashSet<>();
        addTriplets(xors, nums, 0, 0, 0);
        /*
        while(i < nums.length && j < nums.length && k < nums.length){
            System.out.println("("+i+", "+j+", "+k+")");
            System.out.println(xors);
            int xor = nums[i] ^ nums[j] ^ nums[k];
            xors.add(xor);
            // not exhaustive
            if(i == j && j == k){
                k++;
            }else if(i == j){
                j++;
            }else{
                i++;
            }
        }*/
        return xors.size();
    }

    private Set<Integer> addTriplets(Set<Integer> set, int[] arr, int i, int j, int k){
        int n = arr.length;
        if(i >= n || j >= n || k >= n){
            return set;
        }

        Set<Integer> s1 = addTriplets(set, arr, i+1, j, k);
        Set<Integer> s2 = addTriplets(set, arr, i, j+1, k);
        Set<Integer> s3 = addTriplets(set, arr, i, j, k+1);

        set.add(arr[i] ^ arr[j] ^ arr[k]);

        set.addAll(s1);
        set.addAll(s2);
        set.addAll(s3);

        return set;
    }
}