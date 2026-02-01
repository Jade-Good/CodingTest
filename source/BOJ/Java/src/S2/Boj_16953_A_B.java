package S2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16953_A_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        Queue<long[]> que = new ArrayDeque<>();
        que.add(new long[]{A, 1});

        long answer = Long.MAX_VALUE;
        while (!que.isEmpty()) {
            long[] now = que.poll();
            if (now[0] == B) {
                answer = Math.min(answer, now[1]);
            }

            if (now[0] * 2 <= B) {
                que.add(new long[]{now[0] * 2, now[1] + 1});
            }
            if (now[0] * 10 + 1 <= B) {
                que.add(new long[]{now[0] * 10 + 1, now[1] + 1});
            }
        }

        bw.write(Long.toString(answer == Long.MAX_VALUE ? -1 : answer));
        bw.flush();
    }
}
