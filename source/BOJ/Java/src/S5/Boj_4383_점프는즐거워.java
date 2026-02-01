package S5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_4383_점프는즐거워 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input;

        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);

            int N = Integer.parseInt(st.nextToken());

            if (N == 1) {
                sb.append("Jolly\n");
                continue;
            }

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] check = new boolean[N];
            check[0] = true;

            for (int i = 1; i < N; i++) {
                int abs = Math.abs(arr[i] - arr[i - 1]);
                if (abs >= N) {
                    check[0] = false;
                    break;
                } else {
                    check[abs] = true;
                }
            }

            if (check[0]) {
                for (int i = 1; i < N; i++) {
                    if (!check[i]) {
                        check[0] = false;
                        break;
                    }
                }
            }

            sb.append(check[0] ? "Jolly\n" : "Not jolly\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
