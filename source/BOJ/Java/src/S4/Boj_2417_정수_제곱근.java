package S4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_2417_정수_제곱근 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());

        if (n == 0) {
            bw.write("0");
            bw.flush();
            return;
        }

        long start = 0;
        long end = n;
        long result = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (mid == 0) {
                start = 1;
                continue;
            }
            if (mid <= n / mid) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (result * result < n) {
            result++;
        }
        bw.write(Long.toString(result));
        bw.flush();
    }
}
