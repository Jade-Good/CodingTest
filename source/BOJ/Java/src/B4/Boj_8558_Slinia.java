package B4;

import java.io.*;

public class Boj_8558_Slinia {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int result = 1;

        for (int i = 2; i <= n; i++) {
            result = result * i % 10;
        }

        bw.write(Integer.toString(result));
        bw.flush();
    }
}
