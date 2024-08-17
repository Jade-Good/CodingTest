package S5;

import java.io.*;

public class Boj_30010_잘못된_버블정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = n; i > 0; i--) {
            sb.append(i).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
