package S2;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_26518_수열의_극한값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double b = Integer.parseInt(st.nextToken());
        double c = Integer.parseInt(st.nextToken());

        bw.write(Double.toString((b + Math.sqrt(b * b + 4 * c)) / 2));
        bw.flush();
    }
}
