package S4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_25044_에어컨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] hours = new int[3];
        hours[0] = 60 * 15;
        hours[1] = 60 * 18;
        hours[2] = 60 * 21;

        final int ONE_DAY = 24 * 60;

        int cnt = 3;
        while (cnt > 0) {
            cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (hours[j] / ONE_DAY < N) {
                    hours[j] += K + ONE_DAY;
                    cnt++;
                }
            }
        }

        Arrays.sort(hours);

        cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (hours[i] / ONE_DAY == N) {
                cnt++;
                sb.append(String.format("%02d", hours[i] % ONE_DAY / 60))
                        .append(':')
                        .append(String.format("%02d", hours[i] % ONE_DAY % 60))
                        .append('\n');
            }
        }

        bw.write(cnt + "\n" + sb.toString());
        bw.flush();
    }
}
