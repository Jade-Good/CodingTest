package S3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_14936_엘리베이터장난 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int odd = (N + 1) / 2;
        int even = N / 2;
        int k3_1 = (N - 1) / 3 + 1;

        int answer = 1;

        // 동작 1 (모든버튼)
        if (N <= M) {
            answer++;
        }

        // 동작 2 (짝수버튼)
        if (N > 1 && odd <= M) {
            answer++;
        }

        // 동작 3 (홀수버튼)
        if (N > 1 && even <= M) {
            answer++;
        }

        // 동작 4 (3k+1버튼)
        if (N > 2 && k3_1 <= M) {
            answer++;
        }

        // 동작 2 & 동작 4 (짝수버튼 & 3k+1버튼)
        if (N >= 3 && odd + k3_1 <= M) {
            answer++;
        }

        // 동작 3 & 동작 4 (홀수버튼 & 3k+1버튼)
        if (N >= 3 && even + k3_1 <= M) {
            answer++;
        }

        // 동작 1 & 동작 4 (모든버튼 & 3k+1버튼)
        if (N >= 3 && N + k3_1 <= M) {
            answer++;
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }
}

/*

1 2 3 4 5 6 7 8 9 10
1   3   5   7   9
  2   4   6   8   10
1     4     7     10
1 2       6 7 8      (짝+3k1)
    3 4 5       9 10 (홀+3k1)

 */