package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_29863_아르노의_수면_일정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sleep = Integer.parseInt(br.readLine());
        int wakeup = Integer.parseInt(br.readLine());

        if (sleep > 3) {
            sleep = 24 - sleep + wakeup;
        } else {
            sleep = wakeup - sleep;
        }

        bw.write(Integer.toString(sleep));
        bw.flush();
    }
}
