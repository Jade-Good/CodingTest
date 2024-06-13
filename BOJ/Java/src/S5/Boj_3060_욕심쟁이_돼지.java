package S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_3060_욕심쟁이_돼지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            long N = Long.parseLong(br.readLine());
            st = new StringTokenizer(br.readLine());

            long sum = 0;

            for (int j = 0; j < 6; j++) {
                sum += Integer.parseInt(st.nextToken());
            }

            int day = 1;
            while (sum <= N) {
                day++;
                sum *= 4;
            }

            sb.append(day).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
