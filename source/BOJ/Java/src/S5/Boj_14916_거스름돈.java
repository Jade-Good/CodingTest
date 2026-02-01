package S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_14916_거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int five;
        boolean flag = false;

        for (five = n / 5; five >= 0; five--) {
            if ((n - five * 5) % 2 == 0) {
                flag = true;
                break;
            }
        }

        if (flag) {
            bw.write(Integer.toString(five + (n - five * 5) / 2));
        } else {
            bw.write("-1");
        }
        bw.flush();
    }
}
