package B2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_31945_정육면체의네꼭짓점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            boolean[] used = new boolean[8];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 4; i++) {
                used[Integer.parseInt(st.nextToken())] = true;
            }

            if ((used[0] && used[1] && used[2] && used[3]) ||
                    (used[0] && used[1] && used[4] && used[5]) ||
                    (used[0] && used[2] && used[4] && used[6]) ||
                    (used[7] && used[1] && used[3] && used[5]) ||
                    (used[7] && used[4] && used[5] && used[6]) ||
                    (used[7] && used[2] && used[3] && used[6])) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
