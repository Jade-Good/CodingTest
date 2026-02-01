package B4;

import java.io.*;

public class Boj_6887_Squares {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        double N = Double.parseDouble(br.readLine());

        sb.append("The largest square has side length ").append((int) Math.sqrt(N)).append('.');

        bw.write(sb.toString());
        bw.flush();
    }
}
