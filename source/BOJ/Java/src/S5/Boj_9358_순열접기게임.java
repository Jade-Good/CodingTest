package S5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_9358_순열접기게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        long[] arr = new long[100];

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            while (N > 2) {
                for (int i = 0; i < Math.ceil(N / 2.0); i++) {
                    arr[i] += arr[N - i - 1];
                }
                N = (int) Math.ceil(N / 2.0);
            }

            sb.append("Case #").append(t).append(": ").append(arr[0] > arr[1] ? "Alice\n" : "Bob\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
