package B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_14264_정육각형과삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double L = Double.parseDouble(br.readLine());
        System.out.print((Math.sqrt(3.0) / 4.0) * L * L);
    }
}
