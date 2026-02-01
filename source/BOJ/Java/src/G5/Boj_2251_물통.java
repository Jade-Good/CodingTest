package G5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2251_물통 {
    private static int[] give = {0, 0, 1, 1, 2, 2};
    private static int[] receive = {1, 2, 0, 2, 0, 1};
    private static boolean[][] visited;
    private static boolean[] answer;
    private static int[] now;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        now = new int[3];
        now[0] = Integer.parseInt(st.nextToken());
        now[1] = Integer.parseInt(st.nextToken());
        now[2] = Integer.parseInt(st.nextToken());

        visited = new boolean[201][201];
        answer = new boolean[201];

        BFS();

        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                sb.append(i).append(' ');
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void BFS() {
        Queue<AB> q = new ArrayDeque<>();
        q.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;

        while (!q.isEmpty()) {
            AB ab = q.poll();
            int A = ab.A;
            int B = ab.B;
            int C = now[2] - A - B;
            for (int i = 0; i < 6; i++) {
                int[] next = {A, B, C};
                next[receive[i]] += next[give[i]];
                next[give[i]] = 0;
                if (next[receive[i]] > now[receive[i]]) { // 물이 넘침
                    // 초과량 만큼 다시 물통에 넣기
                    next[give[i]] = next[receive[i]] - now[receive[i]];
                    next[receive[i]] = now[receive[i]]; // 대상 물통은 최대로 채우기
                }
                if (!visited[next[0]][next[1]]) { // 방문 배열 체크
                    visited[next[0]][next[1]] = true;
                    q.add(new AB(next[0], next[1]));
                    if (next[0] == 0) { // A의 물의 양이 0일때, C의 양 정답에 넣기
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

    private static class AB {
        int A, B;

        public AB(int a, int b) {
            A = a;
            B = b;
        }
    }
}
