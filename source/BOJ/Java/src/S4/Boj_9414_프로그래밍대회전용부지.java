package S4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Boj_9414_프로그래밍대회전용부지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        final long MAX = 5000000L;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            ArrayList<Integer> list = new ArrayList<>();
            int L;

            while ((L = Integer.parseInt(br.readLine())) != 0) {
                list.add(L);
            }

            list.sort(Collections.reverseOrder());
            long sum = 0;

            for (int i = 0; i < list.size(); i++) {
                int now = list.get(i);
                sum += 2 * (long) Math.pow(now, i + 1);
                if (sum > MAX) {
                    break;
                }
            }

            if (sum > MAX) {
                sb.append("Too expensive\n");
            } else {
                sb.append(sum).append('\n');
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
