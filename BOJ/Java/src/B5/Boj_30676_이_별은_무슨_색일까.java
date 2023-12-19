package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_30676_이_별은_무슨_색일까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());

        if (a >= 620) {
            bw.write("Red");
        } else if (a >= 590) {
            bw.write("Orange");
        } else if (a >= 570) {
            bw.write("Yellow");
        } else if (a >= 495) {
            bw.write("Green");
        } else if (a >= 450) {
            bw.write("Blue");
        } else if (a >= 425) {
            bw.write("Indigo");
        } else {
            bw.write("Violet");
        }

        bw.flush();
    }
}
