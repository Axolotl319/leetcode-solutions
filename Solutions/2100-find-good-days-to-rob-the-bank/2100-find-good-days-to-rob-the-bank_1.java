class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        if(n <= 2 * time || time < 0) return new ArrayList<>();
        int[] daysBeforeGEQ = new int[n];
        int[] daysAfterLEQ = new int[n];
        daysBeforeGEQ[0] = 0;
        daysAfterLEQ[n-1] = 0;
        for(int i = 1; i < n; i++){
            daysBeforeGEQ[i] = daysBeforeGEQ[i-1];
            if(security[i] <= security[i-1]){
                daysBeforeGEQ[i]++;
            }

            daysAfterLEQ[n-1-i] = daysAfterLEQ[n-i];
            if(security[n-1-i] <= security[n-i]){
                daysAfterLEQ[n-1-i]++;
            }
        }

        List<Integer> days = new ArrayList<>();
        for(int i = time; i < n-time; i++){
            if(daysBeforeGEQ[i] >= time && daysAfterLEQ[i] >= time){
                days.add(i);
            }
        }
        return days;
    }
}