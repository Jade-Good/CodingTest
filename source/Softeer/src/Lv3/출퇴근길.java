package Lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 출퇴근길 {
    private static int n, m;
    private static ArrayList<Integer>[] adjList, reverse;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n];
        reverse = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            adjList[x].add(y);
            reverse[y].add(x);
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()) - 1;
        int T = Integer.parseInt(st.nextToken()) - 1;

        boolean[] work = dfs(S, T, new boolean[n]); // 출근
        boolean[] workR = dfs_reverse(S, T, new boolean[n]); // 출근 역순
        boolean[] home = dfs(T, S, new boolean[n]); // 퇴근
        boolean[] homeR = dfs_reverse(T, S, new boolean[n]); // 퇴근 역순

        // StringBuilder sb1 = new StringBuilder();
        // StringBuilder sb2 = new StringBuilder();
        // StringBuilder sb3 = new StringBuilder();
        // StringBuilder sb4 = new StringBuilder();
        // for(int i = 0; i < n; i++) {
        //     sb1.append(work[i] ? 1 : 0).append(' ');
        //     sb2.append(workR[i] ? 1 : 0).append(' ');
        //     sb3.append(home[i] ? 1 : 0).append(' ');
        //     sb4.append(homeR[i] ? 1 : 0).append(' ');
        // }
        // System.out.println(sb1);
        // System.out.println(sb2);
        // System.out.println(sb3);
        // System.out.println(sb4);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (i != S && i != T && work[i] && workR[i] && home[i] && homeR[i]) {
                answer++;
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }

    private static boolean[] dfs(int S, int T, boolean[] visited) { // 시작, 도착, 도착 가능 경로

        Queue<Integer> que = new ArrayDeque<>();
        que.offer(S);

        visited[S] = true;
        visited[T] = true;

        while (!que.isEmpty()) {

            int now = que.poll();

            for (int next : adjList[now]) {

                if (!visited[next]) {
                    que.offer(next);
                    visited[next] = true;
                }

            }
        }

        return visited;
    }

    private static boolean[] dfs_reverse(int S, int T, boolean[] visited) { // 시작, 도착, 도착 가능 경로

        Queue<Integer> que = new ArrayDeque<>();
        que.offer(S);

        visited[S] = true;

        while (!que.isEmpty()) {

            int now = que.poll();

            for (int next : reverse[now]) {

                if (!visited[next]) {
                    que.offer(next);
                    visited[next] = true;
                }

            }
        }

        return visited;
    }
}

/*

< 문제 분석 >
 - n개의 정점과 m개의 단방향 간선 (가중치 X)
 - 집 S, 회사 T
 - 출근길과 퇴근길에 모두 들릴 수 있는 정점의 수(S와 T는 제외)
 - 출근할 때는 S를 얼마든지 여러번 지나도 됨
 - 퇴근 할 때는 T를 얼마든지 여러번 지나도 됨

< 풀이 계획 >
 - DFS 사용하면 될 듯
 - 시간복잡도는 n 10만에 m 20만이라 크게 문제 안됨
 - 출근 dfs, 퇴근 dfs 하고 겹친 노드 카운트
 = 피드백!
     - 같은 곳을 여러번 밟아도 되는듯
     - 사이클이 생기지 않도록 하려면?
     - 시작 위치에 도착하면 도착 가능

< 테케 모음 >
1) 가장 작은 원형
5 5
1 2
2 3
3 4
4 5
5 1
1 5
=> 0

2) 퇴근길 서클 1개
5 6
1 2
2 3
3 4
4 5
5 2
2 1
1 5
=> 3

1 <-> 2 -> 3 -> 4 -> 5
        \___________/

3) 풍선모양
5 6
1 2
1 3
3 4
4 5
5 1
2 1
1 2
=> 0

< 틀리고 해설 본 봤음 >
- 효율적으로 구하기 위해서는 출발지에서 도달 가능한 노드, 도착지 도달 가능한 노드를 모두 구함
- 겹치는 부분이 출근할 때 경유하는 노드임
- 퇴근도 마찬가지로 구하고 4개 모두 겹치는 곳 찾기

*/
