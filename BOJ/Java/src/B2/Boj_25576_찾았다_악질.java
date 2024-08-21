package B2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_25576_찾았다_악질 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += Math.abs(arr[j] - Integer.parseInt(st.nextToken()));
            }
            if (sum > 2000) {
                cnt++;
            }
        }

        bw.write(cnt >= N / 2 ? "YES" : "NO");
        bw.flush();
    }
}
