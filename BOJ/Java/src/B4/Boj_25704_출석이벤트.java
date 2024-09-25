package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_25704_출석이벤트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;

        if (N >= 5) {
            min = Math.min(min, P - 500);
        }
        if (N >= 10) {
            min = Math.min(min, (int) (P * 0.9));
        }
        if (N >= 15) {
            min = Math.min(min, P - 2000);
        }
        if (N >= 20) {
            min = Math.min(min, (int) (P * 0.75));
        }

        bw.write(Integer.toString(min));
        bw.flush();
    }
}
