package B3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_4435_중간계전쟁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        final int[] gandalp = {1, 2, 3, 3, 4, 10};
        final int[] saouron = {1, 2, 2, 2, 3, 5, 10};

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum1 = 0;
            int sum2 = 0;

            for (int i : gandalp) {
                sum1 += i * Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i : saouron) {
                sum2 += i * Integer.parseInt(st.nextToken());
            }

            sb.append("Battle ").append(t).append(": ");

            if (sum1 > sum2) {
                sb.append("Good triumphs over Evil\n");
            } else if (sum1 < sum2) {
                sb.append("Evil eradicates all trace of Good\n");
            } else {
                sb.append("No victor on this battle field\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
