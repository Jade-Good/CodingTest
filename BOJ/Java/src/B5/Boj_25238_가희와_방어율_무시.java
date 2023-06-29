package B5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_25238_가희와_방어율_무시 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double a = Integer.parseInt(st.nextToken());
        double b = Integer.parseInt(st.nextToken());

        double bang = a - a * (b/100);

        bw.write(Integer.toString(bang >= 100 ? 0 : 1));
        bw.flush();
    }
}
