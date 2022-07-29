package lv1;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int row = 0, col = 0;

        for(int s[] : sizes){
            int big = s[0] > s[1] ? s[0] : s[1];
            int small = s[0] > s[1] ? s[1] : s[0];

            if(big > row) row = big;
            if(small > col) col = small;
        }

        return row * col;
    }
}
