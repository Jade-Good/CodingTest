package G4;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1043_거짓말_DisjointSet {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int known = Integer.parseInt(st.nextToken());

        if (known == 0) {
            bw.write(Integer.toString(M));
            bw.flush();
            return;
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // Disjoint Set

        int[] knowns = new int[known]; // 사실을 아는 사람들
        ArrayList<Integer>[] list = new ArrayList[M];

        for (int i = 0; i < known; i++) {
            knowns[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            int people = Integer.parseInt(st.nextToken());

            int first = Integer.parseInt(st.nextToken());
            list[i].add(first);
            first = find(first);

            for (int j = 1; j < people; j++) {
                int member = Integer.parseInt(st.nextToken());
                list[i].add(member);
                union(first, member);
            }
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            boolean flag = true;
            int pp = find(list[i].get(0));
            for (int j = 0; j < known; j++) {
                if (find(pp) == find(knowns[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }

        // Output
        bw.write(Integer.toString(cnt));
        bw.flush();
    }

    private static void union(int a, int b) {
        int ap = find(a);
        int bp = find(b);

        if (ap != bp) parent[ap] = bp;
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}
