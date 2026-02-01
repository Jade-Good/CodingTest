package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_27310_chino_shock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] chars = br.readLine().toCharArray();
        int cnt = 0;

        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i] == '_') {
                cnt++;
            }
        }

        bw.write(Integer.toString(chars.length + 2 + cnt * 5));
        bw.flush();
    }
}
