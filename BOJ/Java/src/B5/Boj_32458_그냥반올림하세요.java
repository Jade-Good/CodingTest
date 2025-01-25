package B5;

import java.io.*;

public class Boj_32458_그냥반올림하세요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.toString((int)Double.parseDouble(br.readLine())));
        bw.flush();
    }
}
