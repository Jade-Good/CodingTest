package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_25494_단순한_문제_Small {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int cnt = 0;

            for (int j = 1; j <= a; j++) {
                for (int k = 1; k <= b; k++) {
                    for (int l = 1; l <= c; l++) {
                        if (j % k == k % l && k % l == l % j) {
                            cnt++;
                        }
                    }
                }
            }
            sb.append(cnt).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
