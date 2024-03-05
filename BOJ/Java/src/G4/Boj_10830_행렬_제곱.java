package G4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_10830_행렬_제곱 {

    private static long n, b;
    private static long[][] temp = new long[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        long[][] a = new long[5][5];
        long[][] answer = new long[5][5];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Long.parseLong(st.nextToken());
            }
            answer[i][i] = 1;
        }

        while (b > 0) {
            if (b % 2 == 1) {
                matrix(answer, a);
            }
            matrix(a, a);
            b /= 2;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(answer[i][j]).append(' ');
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void matrix(long[][] x, long[][] y) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    temp[i][j] += x[i][k] * y[k][j];
                }
                temp[i][j] %= 1000;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                x[i][j] = temp[i][j];
            }
        }
    }
}
