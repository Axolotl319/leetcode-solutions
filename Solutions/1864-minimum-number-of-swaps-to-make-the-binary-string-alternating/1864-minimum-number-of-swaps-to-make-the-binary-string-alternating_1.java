class Solution {
    public int minSwaps(String s) {
        int zeros = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') zeros++;
        }
        int ones = s.length() - zeros;
        if(zeros > ones + 1 || ones > zeros + 1){
            // alternating is impossible
            return -1;
        }
        int swaps = 0;
        if(zeros < ones){
            // valid sequence is 1010...101
            for(int i = 0; i < s.length(); i++){
                if((i % 2 == 0 && s.charAt(i) != '1') ||
                    (i % 2 == 1 && s.charAt(i) != '0')){
                        swaps++;
                    }
            }
        }else if(ones < zeros){
            // valid sequence is 010...010
            for(int i = 0; i < s.length(); i++){
                if((i % 2 == 0 && s.charAt(i) != '0') ||
                    (i % 2 == 1 && s.charAt(i) != '1')){
                        swaps++;
                    }
            }
        }else{
            // check both valid sequences: 1010...10 and 0101...01, return min
            int swapsToStartOne = 0;
            int swapsToStartZero = 0;
            for(int i = 0; i < s.length(); i++){
                if((i % 2 == 0 && s.charAt(i) != '0') ||
                    (i % 2 == 1 && s.charAt(i) != '1')){
                        swapsToStartZero++;
                    }
                if((i % 2 == 0 && s.charAt(i) != '1') ||
                    (i % 2 == 1 && s.charAt(i) != '0')){
                        swapsToStartOne++;
                    }
            }
            swaps = Math.min(swapsToStartOne, swapsToStartZero);
        }
        // every number that needs to be swapped gets counted
        // => total swaps needed is half this value
        swaps /= 2;
        return swaps;
    }
}