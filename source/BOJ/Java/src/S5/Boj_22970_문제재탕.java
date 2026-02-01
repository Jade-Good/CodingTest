package S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_22970_문제재탕 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ans = 1;
        int cnt = 1;
        int before = Integer.parseInt(st.nextToken());
        boolean isUp = true;

        for (int i = 1; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            if (before < now) { // 오르막
                if (isUp) { // 오르막 맞음
                    cnt++;
                } else { // 산 끝남
                    isUp = true;
                    ans = Math.max(ans, cnt);
                    cnt = 2;
                }
            } else if (before > now) { // 내리막
                if (isUp) { // 내리막 시작
                    isUp = false;
                }
                cnt++;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 1;
            }
            before = now;
        }

        ans = Math.max(ans, cnt);

        bw.write(Integer.toString(ans));
        bw.flush();
    }
}
