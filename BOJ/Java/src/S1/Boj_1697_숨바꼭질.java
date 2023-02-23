package S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1697_숨바꼭질 {
    private static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    private static int bfs(int n, int k) {
        boolean[] visit = new boolean[MAX + 1];

        Queue<Integer> que = new ArrayDeque<>();
        que.offer(n);
        visit[n] = true;

        int cnt = 0;
        while (!que.isEmpty()) {

            int size = que.size();

            for (int i = 0; i < size; i++) {
                int now = que.poll();
                if (now == k)
                    return cnt;

                int index = now - 1;

                // 왼쪽
                if (0 <= index && index <= MAX && !visit[index]) {
                    que.offer(index);
                    visit[index] = true;
                }

                // 오른쪽
                index = now + 1;
                if (0 <= index && index <= MAX && !visit[index]) {
                    que.offer(index);
                    visit[index] = true;
                }

                // 순간이동
                index = now * 2;
                if (0 <= index && index <= MAX && !visit[index]) {
                    que.offer(index);
                    visit[index] = true;
                }
            }
            cnt++;
        }
        return -1;
    }
}
