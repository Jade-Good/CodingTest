package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_23795_사장님_도박은_재미로_하셔야_합니다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 0;
        int sum = 0;

        while ((n = Integer.parseInt(br.readLine())) >= 0) {
            sum += n;
        }

        bw.write(Integer.toString(sum));
        bw.flush();
    }
}
