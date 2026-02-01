package P5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1854_K번째최단경로찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> dist = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
            dist.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList.get(a).add(new int[]{b, c});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (dist.get(now[0]).size() >= k) {
                continue;
            }

            dist.get(now[0]).add(now[1]);

            for (int[] a : adjList.get(now[0])) {
                pq.offer(new int[]{a[0], now[1] + a[1]});
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dist.get(i).size() < k) {
                sb.append(-1).append('\n');
            } else {
                sb.append(dist.get(i).get(k - 1)).append('\n');
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}

/*
< 문제 분석 >
- 1번 도시부터 다른 도시로 가는 K번째 최단거리 구하기
- K번째 최단 경로가 없으면 -1 출력

< 풀이 전략 >
- 다익스트라가 기본이 되는 문제인 듯
- 다익스트라의 거리 업데이트에서 큐에 또 넣는 방식인듯?
    - 무한 순환하지 않을까 -> 거리 짧은 순서대로 나오니 K번째 구하면 방문처리 하자

< 반례 모음 >



 */