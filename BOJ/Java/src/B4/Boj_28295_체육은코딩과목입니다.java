package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_28295_체육은코딩과목입니다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int d = 0;
        char[] dir = {'N', 'E', 'S', 'W'};

        for (int i = 0; i < 10; i++) {
            d = (d + Integer.parseInt(br.readLine())) % 4;
        }

        bw.write(Character.toString(dir[d]));
        bw.flush();
    }
}
