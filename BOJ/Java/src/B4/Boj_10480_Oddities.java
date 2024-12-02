package B4;

import java.io.*;

public class Boj_10480_Oddities {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x % 2 == 0) {
                sb.append(x).append(" is even\n");
            } else {
                sb.append(x).append(" is odd\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
