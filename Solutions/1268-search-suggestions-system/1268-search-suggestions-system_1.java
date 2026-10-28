class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products); // lexicographic order

        for(int i = 1; i <= searchWord.length(); i++){
            String searchTerm = searchWord.substring(0, i);
            List<String> list = new ArrayList<>();
            for(String p: products){
                if(p.length() >= i && p.substring(0, i).equals(searchTerm)){
                    list.add(p);
                }
                if(list.size() >= 3) break;
            }
            result.add(list);
        }

        return result;
    }
}