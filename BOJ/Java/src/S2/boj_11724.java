package S2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_11724 {
    public static void main(String[] args) {
        // 1 : input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (!graph[u].contains(v))
                graph[u].add(v);
            if (!graph[v].contains(u))
                graph[v].add(u);
        }

        // 2 : BFS
        Queue<Integer> queue = new LinkedList<>();
        int[] visit = new int[n + 1];
        int gruop = 0;
        for (int i = 1; i <= n; i++) {
            if (visit[i] == 0) {
                gruop++;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int now = queue.poll();
                    if (visit[now] == 0) {
                        visit[now] = gruop;
                        for (int g : graph[now]) {
                            queue.add(g);
                        }
                    }
                }
            }
        }
        System.out.println(gruop);
    }
}
