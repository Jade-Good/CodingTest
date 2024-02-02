package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_24568_Cupcake_Party {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = Integer.parseInt(br.readLine()) * 8 + Integer.parseInt(br.readLine()) * 3 - 28;

        if (result > 0) {
            bw.write(Integer.toString(result));
        } else {
            bw.write('0');
        }
        bw.flush();
    }
}
