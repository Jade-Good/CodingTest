package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1107_리모컨 {
    private static int N, size, ans;
    private static int[] selected;
    private static boolean[] broken_button;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        N = Integer.parseInt(n);
        size = n.length();
        ans = Math.abs(N - 100);

        broken_button = new boolean[10];

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        if (M > 0) {
            st = new StringTokenizer(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            broken_button[Integer.parseInt(st.nextToken())] = true;
        }

        selected = new int[size + 1];
        perm(0);

        System.out.print(ans);
    }

    private static void perm(int idx) {
        if (idx > 0 && (idx == size || idx == size + 1 || idx == size - 1)) {
            int temp = 0;
            for (int i = idx - 1, j = 1; i >= 0; i--, j *= 10) {
                temp += selected[i] * j;
            }
            if (temp == 0) {
                ans = Math.min(ans, 1 + Math.abs(N - temp));
            } else {
                ans = Math.min(ans, idx + Math.abs(N - temp));
            }
            if (idx == size + 1) {
                return;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (!broken_button[i]) {
                selected[idx] = i;
                perm(idx + 1);
            }
        }
    }
}
