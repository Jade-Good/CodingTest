package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_24196_Gomdaord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] chars = br.readLine().toCharArray();

        for (int i = 0; i < chars.length; i += chars[i] - 'A' + 1) {
            sb.append(chars[i]);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
