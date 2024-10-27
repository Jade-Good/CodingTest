package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_5358_FootballTeam {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s;

        while ((s = br.readLine()) != null) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'i') {
                    chars[i] = 'e';
                } else if (chars[i] == 'e') {
                    chars[i] = 'i';
                } else if (chars[i] == 'I') {
                    chars[i] = 'E';
                } else if (chars[i] == 'E') {
                    chars[i] = 'I';
                }
            }
            sb.append(chars).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
