package B3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_1703_생장점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s;

        while ((s = br.readLine()).charAt(0) != '0') {
            StringTokenizer st = new StringTokenizer(s);

            int a = Integer.parseInt(st.nextToken());
            int sum = 1;

            for (int i = 0; i < a; i++) {
                int sf = Integer.parseInt(st.nextToken());
                int lv = Integer.parseInt(st.nextToken());

                sum = sum * sf - lv;
            }
            sb.append(sum).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
