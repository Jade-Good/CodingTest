package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_13913_숨바꼭질4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Subin subin = bfs(N, K);
        int temp = subin.time;

        StringBuilder sb = new StringBuilder();

        while (subin != null) {
            sb.insert(0, subin.index);
            sb.insert(0, ' ');
            subin = subin.before;
        }
        sb.deleteCharAt(0);
        sb.insert(0, '\n');
        sb.insert(0, temp);
        System.out.println(sb);
    }

    private static Subin bfs(int n, int k){

        Queue<Subin> que = new ArrayDeque<>();
        que.offer(new Subin(n, 0, null));

        boolean[] visit = new boolean[100_001];
        visit[n] = true;

        Subin subin = null;
        while (!que.isEmpty()) {
             subin = que.poll();

            if (subin.index == k)
                return subin;

            int index = subin.index*2;
            int time = subin.time+1;

            // 순간이동
            if (index <= k+1 && !visit[index]){
                que.offer(new Subin(index, time, subin));
                visit[index] = true;
            }

            // 왼쪽
            index = subin.index-1;
            if (0<= index && !visit[index]){
                que.offer(new Subin(index, time, subin));
                visit[index] = true;
            }

            // 오른쪽
            index = subin.index+1;
            if (index <= k+1 && !visit[index]){
                que.offer(new Subin(index, time, subin));
                visit[index] = true;
            }
        }
        return null;
    }

    private static class Subin {
        int index, time;
        Subin before;
        public Subin(int index, int time, Subin before) {
            this.index = index;
            this.time = time;
            this.before = before;
        }
    }
}
