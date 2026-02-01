package G4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_1976_여행_가자 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int set_parent = find(Integer.parseInt(st.nextToken()));
        String answer = "YES";

        for (int i = 1; i < M; i++) {
            if (set_parent != find(Integer.parseInt(st.nextToken()))) {
                answer = "NO";
                break;
            }
        }

        bw.write(answer);
        bw.flush();
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) {
        int ap = find(a);
        int bp = find(b);
        if (ap != bp) {
            parent[ap] = bp;
            return true;
        }
        return false;
    }
}
