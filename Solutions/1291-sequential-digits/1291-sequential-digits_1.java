class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        // adding 1111... to a sequential digits number = another sequential digits number
        // unless this new number is divisible by 10
        if(low > high) return result; // error, return empty list
        int lowCopy = low; int highCopy = high;
        int lowDigits = 0; int highDigits = 0;
        int firstLowNum = 0;
        while(highCopy > 0){
            if(lowCopy > 0){
                lowDigits++;
                lowCopy /= 10;
                if(lowCopy < 10){
                    firstLowNum = lowCopy;
                }
            }
            highDigits++;
            highCopy /= 10;
        }
        for(int i = lowDigits; i <= highDigits; i++){
            // find all valid numbers of length i that are between low and high in value
            int unit = i == lowDigits ? firstLowNum : 1;
            int numToAdd = 0; // 11111... - adding this will make another sequential num
            int res = 0;
            while(unit <= i){
                res += unit;
                numToAdd += 1;
                if(unit < i) {
                    res *= 10;
                    numToAdd *= 10;
                }
                unit++;
            }
            numToAdd /= 10; // remove final digit
            if(res > high){
                break;
            }else{
                while(res % 10 != 0 && res <= high){
                    result.add(res);
                    res += numToAdd;
                }
            }
        }
        return result;
    }
}