package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_13866_팀_나누기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;

        min = Math.min(min, Math.abs((a + b) - (d + c)));
        min = Math.min(min, Math.abs((a + c) - (d + b)));
        min = Math.min(min, Math.abs((a + d) - (b + c)));

        bw.write(Integer.toString(min));
        bw.flush();
    }
}
