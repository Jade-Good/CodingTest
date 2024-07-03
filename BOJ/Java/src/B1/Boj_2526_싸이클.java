package B1;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_2526_싸이클 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int temp = N;
        boolean[] used = new boolean[P];

        if (N < P) {
            used[N] = true;
        }

        while (!used[temp * N % P]) {
            used[temp * N % P] = true;
            temp = temp * N % P;
        }


        int cnt = 0;
        used = new boolean[P];
        while (!used[temp * N % P]) {
            used[temp * N % P] = true;
            temp = temp * N % P;
            cnt++;
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
    }
}
