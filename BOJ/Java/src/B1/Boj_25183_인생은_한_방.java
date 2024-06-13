package B1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_25183_인생은_한_방 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        int cnt = 0;

        for (int i = 1; i < N; i++) {
            if (Math.abs(chars[i] - chars[i - 1]) == 1) {
                if (++cnt == 4) {
                    break;
                }
            } else {
                cnt = 0;
            }
        }

        if (cnt == 4) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }
        bw.flush();
    }
}
