package G3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1516_게임개발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N + 1];
        int[] time = new int[N + 1];

        ArrayList<Integer>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            time[i] = a;

            while ((a = Integer.parseInt(st.nextToken())) > -1) {
                adjList[a].add(i);
                d[i]++;
            }
        }

        Queue<Integer> que = new ArrayDeque<>();
        int[] answer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (d[i] == 0) {
                que.offer(i);
                answer[i] = time[i];
            }
        }

        while (!que.isEmpty()) {
            int a = que.poll();
            for (int i : adjList[a]) {
                answer[i] = Math.max(answer[i], answer[a] + time[i]);
                if (--d[i] == 0) {
                    que.offer(i);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
