package S1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16568_엔비스카의_영혼 {
    public static void test(String s) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int[] move = new int[3];
        move[1] = Integer.parseInt(st.nextToken());
        move[2] = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(bfs(N, move)));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] move = new int[3];
        move[1] = Integer.parseInt(st.nextToken());
        move[2] = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(bfs(N, move)));
        bw.close();
    }

    private static int bfs(int N, int[] move) {
        if (N == 0) return 0;
        Queue<Integer> que = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];

        que.add(N);
        visited[N] = true;

        int time = 1;

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int cur = que.poll() - 1;
                if (cur == 0) return time;
                for (int j = 0; j < 3; j++) {
                    if (cur >= move[j] && !visited[cur - move[j]]) {
                        if (cur == move[j]) return time;
                        visited[cur - move[j]] = true;
                        que.add(cur - move[j]);
                    }
                }
            }
            time++;
        }
        return -1;
    }
}