package B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_34893_억지부리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long U = Long.parseLong(st.nextToken());
        long O = Long.parseLong(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        long k = Math.max(0, (U - S) / 3);
        long answer = 0;

        for (long i = Math.max(0, k - 2); i <= k + 2; i++) {
            if (U - 2 * i < 0) {
                continue;
            }
            long cur = Math.min(Math.min(U - 2 * i, O), S + i);
            answer = Math.max(answer, cur);
        }

        System.out.print(answer);
    }
}
