package P5;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj_11003_최솟값_찾기 {
    private static class Window {
        int idx;
        int val;

        public Window(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // 슬라이딩 윈도우 (Deque)
        st = new StringTokenizer(br.readLine());

        Deque<Window> que = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!que.isEmpty() && que.peekLast().val > now) {
                que.pollLast();
            }

            que.add(new Window(i, now));

            if (i - que.peekFirst().idx >= L) {
                que.pollFirst();
            }

            sb.append(que.peekFirst().val).append(' ');
        }

        // Output
        bw.write(sb.toString());
        bw.flush();
    }
}
