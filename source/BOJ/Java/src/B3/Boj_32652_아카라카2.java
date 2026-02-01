package B3;

import java.io.*;

public class Boj_32652_아카라카2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        sb.append("AKA");

        for (int i = 0; i < K; i++) {
            sb.append("RAKA");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
