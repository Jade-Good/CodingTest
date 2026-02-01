package B4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_15439_베라의_패션 {
    private static int N, ans;
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        used = new boolean[N];

        perm(0);

        System.out.print(ans);
    }

    private static void perm(int cnt) {
        if (cnt == 2) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                perm(cnt + 1);
                used[i] = false;
            }
        }
    }
}
