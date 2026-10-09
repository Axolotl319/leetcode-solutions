class Solution {
    private void addToList(int n, String s, List<String> res, int openBrackets){
        if(s.length() == 2*n){
            res.add(s);
            return;
        }

        // can add up to n (s
        if(openBrackets < n){
            addToList(n, s+"(", res, openBrackets+1);
        }

        // can add ) if there is an unmatched (
        if(openBrackets*2 > s.length()){
            addToList(n, s+")", res, openBrackets);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        addToList(n, "", res, 0);
        return res;
    }
}