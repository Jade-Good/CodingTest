package S5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_28238_정보_선생님의_야망 {
    private static int max, one, sec;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[n][5];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = st.nextToken().charAt(0) == '1';
            }
        }

        max = 0;
        one = 0;
        sec = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (i == j) continue;
                cal(i, j, arr);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append('\n');
        for (int i = 0; i < 5; i++) {
            if (i == one || i == sec)
                sb.append('1').append(' ');
            else
                sb.append('0').append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void cal(int a, int b, boolean[][] arr) {
        int cnt = 0;
        for (boolean[] flag : arr) {
            if (flag[a] && flag[b]) {
                cnt++;
            }
        }
        if (cnt > max) {
            max = cnt;
            one = a;
            sec = b;
        }
    }
}
