package B2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_1100_하얀_칸 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] chars = null;

        int ans = 0;

        for (int i = 0; i < 4; i++) {
            chars = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                if (j % 2 == 0 && chars[j] == 'F') {
                    ans++;
                }
            }
            chars = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                if (j % 2 == 1 && chars[j] == 'F') {
                    ans++;
                }
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}
