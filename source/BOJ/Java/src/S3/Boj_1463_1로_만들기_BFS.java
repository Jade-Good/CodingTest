package S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_1463_1로_만들기_BFS {
    private static class Pair {
        int n, d;
        public Pair(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // BFS
        Queue<Pair> queue = new LinkedList<>();
        boolean[] visit = new boolean[N+1];

        queue.add(new Pair(N,0));

        int cnt = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            if (pair.n == 1) {
                cnt = pair.d;
                break;
            }

            if (!visit[pair.n]) {
                visit[pair.n] = true;

                if (pair.n%3 == 0) queue.add(new Pair(pair.n/3, pair.d+1));
                if (pair.n%2 == 0) queue.add(new Pair(pair.n/2, pair.d+1));
                queue.add(new Pair(pair.n - 1, pair.d+1));
            }
        }

        // Output
        System.out.print(cnt);
    }
}
