class Solution {
    public boolean isValid(String s) {
        Stack<Character> open = new Stack<>();
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('{', '}');
        brackets.put('[', ']');
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(brackets.keySet().contains(c)){
                open.push(c);
            }else if(open.isEmpty()){
                return false;
            }else{
                char o = open.pop();
                if(brackets.get(o) != c) return false;
            }
        }
        return open.isEmpty();
    }
}