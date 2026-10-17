class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            sb.append(i);
        }

        String next = sb.toString();
        for(int i = 1; i < k; i++){
            // rearrange into next highest lexicographically
            next = getNextPerm(next);
        }
        return next;
    }

    private String getNextPerm(String str){
        // start from end, look for chars in asc order
        // e.g. abcedb => swap c and d for next highest
        int pivot = -1;
        for(int i = str.length()-1; i > 0; i--){
            if(str.charAt(i-1) < str.charAt(i)){
                pivot = i-1;
                break;
            }
        }
        if(pivot < 0) return ""; // error e.g. k > n!
        char c = str.charAt(pivot);
        for(int j = str.length()-1; j > pivot; j--){
            if(c < str.charAt(j)){
                // swap
                String swapped = str.substring(0, pivot) + str.charAt(j) + str.substring(pivot+1, j) + str.charAt(pivot) + str.substring(j+1);
                // sort second part (after pivot)
                char[] last = swapped.substring(pivot+1).toCharArray();
                Arrays.sort(last);
                // return
                String result = swapped.substring(0, pivot+1);
                for(char ch: last) result += ch;
                return result;
            }
        }
        return ""; // error
    }
}