package G3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1005_ACM_Craft {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 건물 수
            int K = Integer.parseInt(st.nextToken()); // 건물 짓는 순서 개수

            int[] bt = new int[N + 1]; // 건물 짓는 시간
            ArrayList<Integer>[] adjList = new ArrayList[N + 1]; // 건물 짓는 순서
            int[] input = new int[N + 1]; // 선행 규칙 수
            int[] dp = new int[N + 1];

            // 건물 짓는 시간 저장
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                bt[j] = Integer.parseInt(st.nextToken());
                adjList[j] = new ArrayList<>();
            }

            // 건물 짓는 순서 저장 & 선행 규칙 카운트
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                adjList[X].add(Y);
                input[Y]++;
            }

            // 선행 규칙이 0개인 건물 부터 시작
            Queue<Integer> que = new ArrayDeque<>();
            for (int j = 1; j <= N; j++) {
                if (input[j] == 0) {
                    que.add(j);
                    dp[j] = bt[j];
                }
            }

            while (!que.isEmpty()) {
                int now = que.poll();

                for (int next : adjList[now]) { // 현재 건물과 연결된 건물의 선행 규칙 -1
                    input[next]--;
                    dp[next] = Math.max(dp[now] + bt[next], dp[next]); // 건물을 짓는데 걸리는 시간 최대값으로 갱신
                    if (input[next] == 0) { // 선행 규칙이 0개가 되면 큐에 넣어주기
                        que.add(next);
                    }
                }
            }
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
