package B2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_8320_직사각형을_만드는_방법 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (i * j <= n) {
                    cnt++;
                } else {
                    break;
                }
            }
        }
        bw.write(Integer.toString(cnt));
        bw.flush();
    }
}