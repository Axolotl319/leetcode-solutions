class Solution {
    private int possibleJumps(int[] nums,
                                int jumps, 
                                int index, 
                                HashMap<Integer, Integer> primes){
        if(index == nums.length - 1){
            return jumps;
        }

        int right = possibleJumps(nums, jumps+1, index+1, primes);
        if(primes.containsKey(nums[index]) && index < primes.get(nums[index])){
            int move = possibleJumps(nums, jumps+1, primes.get(nums[index]), primes);
            return Math.min(move, right);
        }
        return right;
    }

    public int minJumps(int[] nums) {
        HashMap<Integer, Integer> primes = new HashMap<>();
        for(int x = 0; x < nums.length; x++){
            if(isPrime(nums[x])){
                primes.put(nums[x], 0);
            }
            for(int y = 1; y <= nums[x]; y++){
                if(nums[x] % y == 0 && primes.containsKey(y)){
                    primes.put(y, x);
                }        
            }
        }

        return possibleJumps(nums, 0, 0, primes);
    }

    private boolean isPrime(int n){
        if(n == 1) return false;
        for(int i = 2; i <= n/2; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}