package P5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_1786_찾기 {
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        String P = br.readLine();
        int tl = T.length();
        int pl = P.length();
        int[] table = new int[pl];

        // 부분 일치 테이블 만들기
        int j = 0;
        for (int i = 1; i < pl; i++) {
            if (P.charAt(i) != P.charAt(j)) {
                if (j > 0) j = table[j - 1];
            } else {
                j++;
                table[i]++;
            }
        }
        System.out.println(Arrays.toString(table));
    }
}
