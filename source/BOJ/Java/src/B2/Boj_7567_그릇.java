package B2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_7567_그릇 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] chars = br.readLine().toCharArray();

        int sum = 10;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                sum += 5;
            } else {
                sum += 10;
            }
        }
        bw.write(Integer.toString(sum));
        bw.flush();
    }
}
