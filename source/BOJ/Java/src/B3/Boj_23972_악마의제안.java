package B3;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_23972_악마의제안 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long K = Integer.parseInt(st.nextToken());
        long N = Integer.parseInt(st.nextToken());

        if (N == 1) bw.write("-1");
        else {
            int answer = (int) ((K * N) / (N - 1));
            if ((K * N) % (N - 1) != 0) answer++;
            bw.write(Integer.toString(answer));
        }
        bw.flush();
    }
}
