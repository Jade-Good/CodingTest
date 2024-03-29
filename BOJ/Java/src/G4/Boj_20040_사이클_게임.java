package G4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_20040_사이클_게임 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int answer = 0;

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            if (!union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))) {
                answer = i;
                break;
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) {
        int ap = find(a);
        int bp = find(b);

        if (ap == bp) return false;
        else if (a == ap && b == bp) parent[ap] = bp;
        else parent[bp] = ap;

        return true;
    }
}
