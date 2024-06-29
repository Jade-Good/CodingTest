package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_19602_Dog_Treats {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if (Integer.parseInt(br.readLine()) + 2 * Integer.parseInt(br.readLine()) + 3 * Integer.parseInt(br.readLine())
                >= 10) {
            bw.write("happy");
        } else {
            bw.write("sad");
        }
        bw.flush();
    }
}
