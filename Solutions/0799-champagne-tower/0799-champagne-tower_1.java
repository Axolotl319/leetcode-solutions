class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        int row = 0;
        while(poured > row){
            row++;
            poured -= row;
            if(row >= query_row) return 1;
        }
        if(poured <= 0) return 0; // havent reached row yet and liquid all used up
        int denom = 2*query_row - 2;
        if(query_glass == 1 || query_glass == query_row){
            return poured / denom;
        }else{
            return 2*poured / denom;
        }
    }
}