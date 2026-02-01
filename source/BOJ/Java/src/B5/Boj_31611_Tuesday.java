package B5;

import java.io.*;

public class Boj_31611_Tuesday {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        bw.write(x % 7 == 2 ? "1" : "0");
        bw.flush();
    }
}
