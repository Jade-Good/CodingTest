package B4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_32776_가희와4시간의벽2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int S = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        if (S <= F || S <= 240) {
            bw.write("high speed rail");
        } else {
            bw.write("flight");
        }

        bw.flush();
    }
}
