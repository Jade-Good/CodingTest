package G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_12851_숨바꼭질2 {
    private static int min = Integer.MAX_VALUE, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        bfs(N, K);
        System.out.println(min);
        System.out.println(cnt);
    }

    private static void bfs(int n, int k){
        Queue<Subin> que = new ArrayDeque<>();
        que.offer(new Subin(n, 0));

        boolean[] visit = new boolean[100_001];

        while (!que.isEmpty()) {
            Subin subin = que.poll();

            visit[subin.index] = true;

            if (subin.index == k) {
                if (min == subin.time)
                    cnt++;
                else if (min > subin.time){
                    cnt = 1;
                    min = subin.time;
                }
                continue;
            }

            if (subin.time > min) continue;

            int index = subin.index-1;
            int time = subin.time+1;

            // 왼쪽
            if (0<= index && !visit[index]){
                que.offer(new Subin(index, time));
            }

            // 오른쪽
            index = subin.index+1;
            if (index <= k+1 && !visit[index]){
                que.offer(new Subin(index, time));
            }

            // 순간이동
            index = subin.index*2;
            if (index <= k+1 && !visit[index]){
                que.offer(new Subin(index, time));
            }
        }
    }

    private static class Subin {
        int index, time;

        public Subin(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
}
