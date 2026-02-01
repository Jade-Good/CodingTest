package B4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_10188_Quadrilateral {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    sb.append('X');
                }
                sb.append('\n');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
