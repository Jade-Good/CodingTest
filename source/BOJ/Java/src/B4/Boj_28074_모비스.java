package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_28074_모비스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] check = new boolean[26];

        char[] chars = br.readLine().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            check[chars[i] - 'A'] = true;
        }

        if (check['M' - 'A'] && check['O' - 'A'] && check['B' - 'A'] && check['I' - 'A'] && check['S' - 'A']) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }
        bw.flush();
    }
}
