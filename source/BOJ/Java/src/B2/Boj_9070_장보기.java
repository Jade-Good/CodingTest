package B2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_9070_장보기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int cost = 0;
            double WpC = 0.0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                double W = Double.parseDouble(st.nextToken());
                double C = Double.parseDouble(st.nextToken());

                if (WpC < W / C || (WpC == W / C && cost > C)) {
                    WpC = W / C;
                    cost = (int) C;
                }
            }

            sb.append(cost).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
