package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_8699_RICESACK {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = 0;

            for (int j = 0; j < 5; j++) {
                max = Math.max(max, Integer.parseInt(st.nextToken()));
            }

            sb.append("Case #").append(i).append(": ").append(max).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
