class Solution {
    public String largestMerge(String word1, String word2) {
        // indexes
        int i = 0; int j = 0;
        StringBuilder merge = new StringBuilder();
        while(i < word1.length() || j < word2.length()){
            if(i >= word1.length()){
                merge.append(word2.substring(j));
                j = word2.length();
            }else if(j >= word2.length()){
                merge.append(word1.substring(i));
                i = word1.length();
            }else{
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(j);
                if(word1.substring(i).compareTo(word2.substring(j)) > 0){
                    merge.append(c1);
                    i++;
                }else{
                    merge.append(c2);
                    j++;
                }
            }
        }
        return merge.toString();
    }
}