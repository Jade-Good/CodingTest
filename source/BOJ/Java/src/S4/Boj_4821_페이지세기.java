package S4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_4821_페이지세기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int max;

        while ((max = Integer.parseInt(br.readLine())) != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ",");
            boolean[] used = new boolean[max + 1];

            while (st.hasMoreTokens()) {
                String s = st.nextToken();

                if (s.contains("-")) {
                    StringTokenizer st2 = new StringTokenizer(s, "-");
                    int start = Integer.parseInt(st2.nextToken());
                    int end = Integer.parseInt(st2.nextToken());

                    for (int i = start; i <= end && i <= max; i++) {
                        used[i] = true;
                    }
                } else {
                    int page = Integer.parseInt(s);
                    if (0 < page && page <= max) {
                        used[Integer.parseInt(s)] = true;
                    }
                }
            }

            int cnt = 0;

            for (boolean use : used) {
                if (use) cnt++;
            }

            sb.append(cnt).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
