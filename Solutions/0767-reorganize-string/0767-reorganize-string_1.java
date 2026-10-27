class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> frequencies = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int f = frequencies.getOrDefault(c, 0) +1;
            frequencies.put(c, f);
        }
        // go through alternating letters
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while(count < s.length()){
            for(char c: frequencies.keySet()){
                int f = frequencies.get(c);
                if(f > 0){
                    sb.append(c);
                    frequencies.put(c, f-1);
                    count++;
                }
            }
        }

        String str = sb.toString();
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == str.charAt(i-1)){
                return "";
            }
        }
        return str;
    }
}