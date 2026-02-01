package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_32775_가희와4시간의벽1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if (Integer.parseInt(br.readLine()) <= Integer.parseInt(br.readLine())) {
            bw.write("high speed rail");
        } else {
            bw.write("flight");
        }
        bw.flush();
    }
}
