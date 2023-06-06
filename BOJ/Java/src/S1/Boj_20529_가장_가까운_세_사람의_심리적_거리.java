package S1;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_20529_가장_가까운_세_사람의_심리적_거리 {
    private static int N, ans;
    private static String[] mbti;
    private static String[] selected = new String[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            N = Integer.parseInt(br.readLine());
            mbti = new String[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                mbti[i] = st.nextToken();
            }

            if (N <= 32) {
                ans = 12;
                combination(0, 0);

                sb.append(ans).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void combination(int now, int cnt) {
        if (cnt == 3) {
            calc_diff();
            return;
        }
        for (int i = now; i <= N - (3 - cnt); i++) {
            selected[cnt] = mbti[i];
            combination(i + 1, cnt + 1);
        }
    }

    private static void calc_diff() {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += cnt_diff(selected[0].charAt(i), selected[1].charAt(i), selected[2].charAt(i));
        }
        ans = Math.min(ans, sum);
    }

    private static int cnt_diff(char a, char b, char c) {
        if (a == b && a == c) return 0;
        else if (a != b && a != c && b != c) return 3;
        else if ((a == b && a != c) || (b == c && a != c) || (a == c && a != b)) return 2;
        else return 1;
    }
}
