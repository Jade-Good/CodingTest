package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_13136_Do_Not_Touch_Anything {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long R = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        long N = Integer.parseInt(st.nextToken());

        bw.write(Long.toString((R % N == 0 ? R / N : R / N + 1) * (C % N == 0 ? C / N : C / N + 1)));
        bw.flush();
    }
}
