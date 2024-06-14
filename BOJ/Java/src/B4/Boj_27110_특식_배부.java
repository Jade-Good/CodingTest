package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_27110_특식_배부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = Math.min(N, Integer.parseInt(st.nextToken()));
        sum += Math.min(N, Integer.parseInt(st.nextToken()));
        sum += Math.min(N, Integer.parseInt(st.nextToken()));

        bw.write(Integer.toString(sum));
        bw.flush();
    }
}
