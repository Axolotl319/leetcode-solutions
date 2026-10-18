class Solution {
    public int largestPalindrome(int n) {
        int smallest = 1;
        for(int i = 1; i < n; i++){
            smallest *= 10;
        }
        int largest = smallest * 10 - 1;
        int max = 0;
        for(int i = largest; i >= smallest; i--){
            for(int j = i; j >= smallest; j--){
                int mult = i*j;
                if(palindrome(mult)){
                    max = Math.max(max, mult);
                }
            }
        }
        return max % 1337;
    }

    private boolean palindrome(int n){
        String s = ""+n;
        int len = s.length();
        for(int i = 0; i <= len/2; i++){
            if(s.charAt(i) != s.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }
}