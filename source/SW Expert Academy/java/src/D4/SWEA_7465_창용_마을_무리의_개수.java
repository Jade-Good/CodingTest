package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7465_창용_마을_무리의_개수 {
    private static int[] disjoint;
    private static int N;

    //        public static void main(String[] args) throws IOException{
    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            make_Set();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            answer = 0;

            for (int i = 1; i <= N; i++) {
                if(disjoint[i] == i) answer ++;
            }

            System.out.println("#" + t + " " + answer);
        }
    }

    private static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 == p2) return;

        disjoint[p1] = p2;
    }

    private static int find(int n) {
        if (disjoint[n] == n)
            return n;
        else
            return disjoint[n] = find(disjoint[n]);
    }

    private static void make_Set() {
        disjoint = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            disjoint[i] = i;
        }
    }
}
