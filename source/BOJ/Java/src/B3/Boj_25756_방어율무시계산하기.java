package B3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_25756_방어율무시계산하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        double V = 0;

        for (int i = 0; i < N; i++) {
            double A = Double.parseDouble(st.nextToken()) / 100.0;
            V = V + A - V * A;
            sb.append(V * 100).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
