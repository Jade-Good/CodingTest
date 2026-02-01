package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_6840_Who_is_in_the_middle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        if ((a > b && b > c) || (a < b && b < c)) {
            bw.write(Integer.toString(b));
        } else if ((b > a && a > c) || (b < a && a < c)) {
            bw.write(Integer.toString(a));
        } else {
            bw.write(Integer.toString(c));
        }

        bw.flush();
    }
}
