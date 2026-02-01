package B4;

import java.io.*;

public class Boj_32025_체육은수학과목입니다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double H = Integer.parseInt(br.readLine());
        int W = Integer.parseInt(br.readLine());

        bw.write(Integer.toString((int)(Math.min(H, W) / 2.0  * 100)));
        bw.flush();
    }
}
