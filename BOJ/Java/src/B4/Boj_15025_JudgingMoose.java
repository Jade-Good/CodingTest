package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_15025_JudgingMoose {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        if (l == 0 && r == 0) {
            sb.append("Not a moose");
        } else if (l == r) {
            sb.append("Even ").append(l * 2);
        } else {
            sb.append("Odd ").append(Math.max(l, r) * 2);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
