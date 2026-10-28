class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, String> ogToSorted = new HashMap<>();
        for(String str: strs){
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String sorted = Arrays.toString(cs);
            ogToSorted.put(str, sorted);
        }
        List<List<String>> result = new ArrayList<>();
        boolean[] inSet = new boolean[strs.length];
        for(int i = 0; i < strs.length; i++){
            if(inSet[i]) continue;
            List<String> nextSet = new ArrayList<>();
            nextSet.add(strs[i]);
            String sorted = ogToSorted.get(strs[i]);
            for(int j = i+1; j < strs.length; j++){
                if(ogToSorted.get(strs[j]).equals(sorted)){
                    nextSet.add(strs[j]);
                    inSet[j] = true;
                }
            }
            result.add(nextSet);
        }
        return result;
    }
}