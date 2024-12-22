package B4;

import java.io.*;

public class Boj_14065_Gorivo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double x = Double.parseDouble(br.readLine());

        bw.write(Double.toString(378541.1784 / (1609.344 * x)));
        bw.flush();
    }
}
/*

1갤런당 x 마일
1갤런 = 3.785411784L
1마일 = 1609.344M

1갤런 = 1609.344 * x 미터 = 3.785411784 리터

1미터 = 3.785411784 / 1609.344 * x
100000 = 37854.11784 / (1609.344 * x)

 */