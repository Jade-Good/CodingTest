package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_10987_모음의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] chars = br.readLine().toCharArray();
        char[] target = {'a', 'e', 'i', 'o', 'u'};

        int answer = 0;
        for (char c : chars) {
            for (char tc : target) {
                if (c == tc) {
                    answer++;
                }
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }
}
