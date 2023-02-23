package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_13549_숨바꼭질3 {
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

        Queue<Subin> que = new ArrayDeque<>();
        que.offer(new Subin(n, 0));
        visit[n] = true;


        while (!que.isEmpty()) {
            Subin subin = que.poll();
            if (subin.index == k)
                return subin.time;

            int index = subin.index * 2;
            int time = subin.time + 1;

            // 순간이동
            if (0 <= index && index <= MAX && !visit[index]) {
                que.offer(new Subin(index, time - 1));
                visit[index] = true;
            }

            // 왼쪽
            index = subin.index - 1;
            if (0 <= index && index <= MAX && !visit[index]) {
                que.offer(new Subin(index, time));
                visit[index] = true;
            }

            // 오른쪽
            index = subin.index + 1;
            if (0 <= index && index <= MAX && !visit[index]) {
                que.offer(new Subin(index, time));
                visit[index] = true;
            }
        }
        return -1;
    }

    private static class Subin {
        int index, time;

        public Subin(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
}
