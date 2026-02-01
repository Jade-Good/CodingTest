package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_4299_AFC_윔블던 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a < b || (a % 2 != 0 && b == 0)) {
            sb.append(-1);
        } else if (a == b) {
            sb.append(a).append(' ').append(0);
        } else if (a % 2 == 0 && b == 0) {
            sb.append(a / 2).append(' ').append(a / 2);
        } else if (a % 2 != b % 2) {
            sb.append(-1);
        } else {
            sb.append((a + b) / 2).append(' ').append(a - (a + b) / 2);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
