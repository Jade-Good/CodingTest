package B2;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_1362_펫 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (o == 0 && w == 0) break;

            boolean isLive = true;

            while (true) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                char c = st1.nextToken().charAt(0);
                int n = Integer.parseInt(st1.nextToken());

                if (c == '#' && n == 0) break;
                else if (!isLive) {
                    continue;
                } else if (c == 'F') {
                    w += n;
                } else {
                    w -= n;
                }

                if (w <= 0) isLive = false;
            }

            if (isLive) {
                if (w > o / 2 && o * 2 > w) sb.append(t).append(' ').append(":-)\n");
                else sb.append(t).append(' ').append(":-(\n");
            } else {
                sb.append(t).append(' ').append("RIP\n");
            }

            t++;
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
