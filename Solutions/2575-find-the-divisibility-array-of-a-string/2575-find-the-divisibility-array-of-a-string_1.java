class Solution {
    public int[] divisibilityArray(String word, int m) {
        long prefix = 0;
        int n = word.length();
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            int digit = word.charAt(i) - '0';
            prefix *= 10;
            prefix += digit;
            prefix %= m; // only store the remainder to prevent overflow
            if(prefix == 0){
                result[i] = 1;
            }else{
                result[i] = 0;
            }
        }
        return result;
    }
}