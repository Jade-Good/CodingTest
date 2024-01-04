package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_15873_공백_없는_AB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int sum = 0;

        if (s.charAt(0) == '0') {
            sum = Integer.parseInt(s);
        } else if (s.length() > 2 && s.startsWith("10")) {
            sum = 10 + Integer.parseInt(s.substring(2));
        } else {
            sum = (s.charAt(0) - '0') + (Integer.parseInt(s.substring(1)));
        }

        bw.write(Integer.toString(sum));
        bw.flush();
    }
}
