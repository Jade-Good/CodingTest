package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_24736_Football_Scoring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            sum += Integer.parseInt(st.nextToken()) * 6;
            sum += Integer.parseInt(st.nextToken()) * 3;
            sum += Integer.parseInt(st.nextToken()) * 2;
            sum += Integer.parseInt(st.nextToken());
            sum += Integer.parseInt(st.nextToken()) * 2;

            sb.append(sum).append(' ');
        }

        bw.write(sb.toString().trim());
        bw.flush();
    }
}
