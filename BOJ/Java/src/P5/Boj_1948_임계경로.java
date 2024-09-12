package P5;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1948_임계경로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] indegree = new int[n + 1];

        ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
        ArrayList<ArrayList<Edge>> adjList_reverse = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
            adjList_reverse.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            adjList.get(out).add(new Edge(in, time));
            adjList_reverse.get(in).add(new Edge(out, time));
            indegree[in]++;
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        // 위상 정렬
        int[] critical_path = new int[n + 1]; // 걸린 시간의 최댓값
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(start);

        while (!que.isEmpty()) {
            int now = que.poll();

            for (Edge next : adjList.get(now)) {
                critical_path[next.v] = Math.max(critical_path[next.v], critical_path[now] + next.time);
                if (--indegree[next.v] == 0) {
                    que.offer(next.v);
                }
            }
        }

        // 역방향 위상 정렬
        boolean[] visited = new boolean[n + 1];
        que.offer(end);
        int cnt = 0;

        while (!que.isEmpty()) {
            int now = que.poll();
            for (Edge next : adjList_reverse.get(now)) {
                if (critical_path[now] == critical_path[next.v] + next.time) {
                    cnt++;
                    if (!visited[next.v]) {
                        que.offer(next.v);
                        visited[next.v] = true;
                    }
                }
            }
        }

        sb.append(critical_path[end]).append('\n').append(cnt);
        bw.write(sb.toString());
        bw.flush();
    }

    private static class Edge {
        int v;
        int time;

        public Edge(int v, int time) {
            this.v = v;
            this.time = time;
        }
    }
}

/*

< 문제 분석 >
 - 단방향 비순환 그래프
 - 시작 점부터 도착 점까지 가장 오래 걸린 시간과 그 루트가 건넌 도로의 수를 출력
 - 시작 노드는 진입 차수가, 도착 노드는 진출 차수가 0이다.

< 풀이 계획 >
 - 수 많은 경로 중 최대값을 찾아야 하므로 BFS 사용
 - 위상 정렬 + DP 처럼 해당 도시에 진입하는 최대 시간 업데이트
 - 시간이 가장 많이 걸린 경로부터 확인할 수 있도록 우선순위큐 써도 좋을 듯
 - 현재위치, 걸린시간, 건넌 다리수 가 포함된 class 생성

< 반례 모음 >
1) 최소
2
1
1 2 1
1 2
=> 1 1

2) 예제 1번
7
9
1 2 4
1 3 2
1 4 3
2 6 3
2 7 5
3 5 1
4 6 4
5 6 2
6 7 5
1 7
=> 12 5

3) 질문 발췌 1 (https://www.acmicpc.net/board/view/111114)
5
9
1 4 5
1 3 6
3 5 3
2 5 3
2 3 7
1 2 2
1 5 9
3 4 1
5 4 2
1 4
=> 14 4

4) 질문 발췌 2 (https://www.acmicpc.net/board/view/69771)
5
7
1 2 1
1 3 3
2 3 2
2 4 1
2 5 3
3 5 1
4 5 1
1 5
=> 4 5

4) 질문 발췌 2-1
5
7
1 2 1
1 3 3
2 3 2
2 4 1
4 5 1
3 5 1
2 5 3
1 5
=> 4 5

 */