package B2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_23320_홍익절대평가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st2.nextToken());
        int Y = Integer.parseInt(st2.nextToken());
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(st1.nextToken()) >= Y) {
                cnt++;
            }
        }

        sb.append(N * X / 100).append(' ');
        sb.append(cnt);

        bw.write(sb.toString());
        bw.flush();
    }
}
