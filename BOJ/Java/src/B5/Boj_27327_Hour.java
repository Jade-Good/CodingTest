package B5;

import java.io.*;

public class Boj_27327_Hour {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(n * 24));
        bw.flush();
    }
}
