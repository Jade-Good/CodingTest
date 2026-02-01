package G5;

import java.io.*;

public class Boj_11729_하노이_탑_이동_순서 {
    private static int cnt;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        cnt = 0;
        sb = new StringBuilder();
        hanoi(N, 1, 2, 3);

        bw.write(cnt + "\n");
        bw.write(sb.toString());
        bw.flush();
    }

    private static void hanoi(int now, int start, int temp, int end) {
        if (now == 1) {
            cnt++;
            sb.append(start).append(' ').append(end).append('\n');
        } else {
            hanoi(now - 1, start, end, temp);
            cnt++;
            sb.append(start).append(' ').append(end).append('\n');
            hanoi(now - 1, temp, start, end);
        }
    }
}