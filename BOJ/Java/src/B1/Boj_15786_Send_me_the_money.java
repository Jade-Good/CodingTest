package B1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_15786_Send_me_the_money {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[] ward = br.readLine().toCharArray();

        for (int i = 0; i < M; i++) {
            char[] nw = br.readLine().toCharArray();

            int idx = 0;
            for (char c : nw) {
                if (c == ward[idx] && ++idx == N) {
                    break;
                }
            }
            if (idx == N) {
                sb.append(true).append('\n');
            } else {
                sb.append(false).append('\n');
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
