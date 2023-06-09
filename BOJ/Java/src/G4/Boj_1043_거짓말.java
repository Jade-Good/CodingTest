package G4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1043_거짓말 {
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        ArrayList<Integer>[] person = new ArrayList[N + 1];
        ArrayList<Integer>[] party = new ArrayList[M];
        Boolean[] know = new Boolean[N + 1];
        Boolean[] visited = new Boolean[M];

        for (int i = 1; i <= N; i++) {
            person[i] = new ArrayList<>();
            know[i] = false;
        }

        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
            visited[i] = false;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int person_cnt = Integer.parseInt(st1.nextToken());
            for (int j = 0; j < person_cnt; j++) {
                int ps = Integer.parseInt(st1.nextToken());
                party[i].add(ps); // 파티 별 참가자 기록
                person[ps].add(i); // 개인 별 참가 파티 기록
            }
        }

        // BFS
        int cnt = M;
        Queue<Integer> que = new ArrayDeque<>();

        // 처음 부터 진실을 아는 사람들 큐 초기화
        int know_cnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < know_cnt; i++) {
            int k = Integer.parseInt(st.nextToken());
            know[k] = true;
            que.add(k);
        }

        while (!que.isEmpty()) {
            int np = que.poll();
            for (int pt : person[np]) {
                if (!visited[pt]) {
                    visited[pt] = true;
                    cnt--;
                    for (int ps : party[pt]) {
                        if (!know[ps]) {
                            know[ps] = true;
                            que.add(ps);
                        }
                    }
                }
            }
        }

        // Output
        bw.write(Integer.toString(cnt));
        bw.flush();
    }
}
