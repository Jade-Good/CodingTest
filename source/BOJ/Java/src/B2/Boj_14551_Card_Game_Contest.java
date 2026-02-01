package B2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_14551_Card_Game_Contest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int sum = 1;

        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(br.readLine());
            if (A > 0) {
                sum = (sum * A) % M;
            }
        }

        bw.write(Integer.toString(sum % M));
        bw.flush();
    }
}
