package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_16486_운동장_한_바퀴 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double b1 = Double.parseDouble(br.readLine());
        double b2 = Double.parseDouble(br.readLine());

        double answer = (2 * b1) + (2 * 3.141592 * b2);

        bw.write(Double.toString(answer));
        bw.flush();
    }
}
