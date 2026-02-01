package B3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_3034_앵그리창영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        double max = Math.sqrt(W * W + H * H);

        for (int i = 0; i < N; i++) {
            if (Double.parseDouble(br.readLine()) <= max) {
                sb.append("DA");
            } else {
                sb.append("NE");
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
