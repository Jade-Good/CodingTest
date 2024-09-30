package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_16099_LargerSportFacility {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long l1 = Long.parseLong(st.nextToken());
            long w1 = Long.parseLong(st.nextToken());
            long l2 = Long.parseLong(st.nextToken());
            long w2 = Long.parseLong(st.nextToken());

            if (l1 * w1 > l2 * w2) {
                sb.append("TelecomParisTech");
            } else if (l1 * w1 < l2 * w2) {
                sb.append("Eurecom");
            } else {
                sb.append("Tie");
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
