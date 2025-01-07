package S3;

import java.io.*;
import java.util.*;

public class Boj_32687_반복수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long l = Long.parseLong(st.nextToken());
        long r = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long res = 0;

        for (int i = 1; i < 1_000_000; i++) {
            String s = Integer.toString(i);

            // i의 길이가 k와 같으면 처리
            if (s.length() != k) continue;

            long x = i;  // 숫자 x는 처음에는 i와 같음
            for (int j = 0; x <= r; j++) {
                if (l <= x && x % m == 0) {
                    res++;  // 조건을 만족하는 수가 있으면 카운트
                }

                // 반복수를 계속 만들어 나감
                x = 10 * x + (s.charAt(j % k) - '0');
            }
        }

        bw.write(Long.toString(res));
        bw.flush();
    }
}
