package Lv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 진정한효도 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] map = new int[3][3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            min = Math.min(min, getMinSum(map[i][0], map[i][1], map[i][2]));
            min = Math.min(min, getMinSum(map[0][i], map[1][i], map[2][i]));
        }

        bw.write(Integer.toString(min));
        bw.flush();
    }

    private static int getMinSum(int a, int b, int c) {
        int sa = Math.abs(a - b) + Math.abs(a - c);
        int sb = Math.abs(a - b) + Math.abs(b - c);
        int sc = Math.abs(a - c) + Math.abs(b - c);

        if (sa <= sb && sa <= sc) {
            return sa;
        }
        if (sb <= sa && sb <= sc) {
            return sb;
        }
        return sc;
    }
}
