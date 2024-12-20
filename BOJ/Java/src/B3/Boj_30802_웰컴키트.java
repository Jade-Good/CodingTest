package B3;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_30802_웰컴키트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int sum = 0;

        for (int i = 0; i < 6; i++) {
            sum += arr[i] / T;
            sum += arr[i] % T == 0 ? 0 : 1;
        }

        sb.append(sum).append('\n').append(N / P).append(' ').append(N % P);
        bw.write(sb.toString());
        bw.flush();
    }
}
