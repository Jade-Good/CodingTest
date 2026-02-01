package lv1;

import java.util.Scanner;

public class x만큼_간격이_있는_n개의_숫자 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long ac = x;

        for(int i = 0; i < n; i++){
            answer[i] = ac;
            ac += x;
        }

        return answer;
     }
}
