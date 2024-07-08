package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_28431_양말_짝_맞추기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] socks = new int[10];

        for (int i = 0; i < 5; i++) {
            socks[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 0; i < 10; i++) {
            if (socks[i] % 2 != 0) {
                bw.write(Integer.toString(i));
                break;
            }
        }
        bw.flush();
    }
}
