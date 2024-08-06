package B1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_29732_Rick_Roll_Virus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] virus = new boolean[N];
        char[] chars = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            if (chars[i] == 'R') {
                int start = Math.max(0, i - K);
                int end = Math.min(N - 1, i + K);
                for (int j = start; j <= end; j++) {
                    virus[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (virus[i]) {
                count++;
            }
        }

        bw.write(count > M ? "No" : "Yes");
        bw.flush();
    }
}
