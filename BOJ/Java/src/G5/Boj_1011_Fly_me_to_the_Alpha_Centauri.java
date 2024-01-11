package G5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_1011_Fly_me_to_the_Alpha_Centauri {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int distance = y - x; // 이동 할 거리

            int max = (int) Math.sqrt(distance);

            if (max == Math.sqrt(distance)) {
                sb.append(max * 2 - 1).append('\n');
            } else if (distance <= max * max + max) {
                sb.append(max * 2).append('\n');
            } else {
                sb.append(max * 2 + 1).append('\n');
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
