package B3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_2501_약수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                if (++cnt == K) {
                    bw.write(Integer.toString(i));
                    break;
                }
            }
        }

        if (cnt != K) {
            bw.write('0');
        }

        bw.flush();
    }
}
