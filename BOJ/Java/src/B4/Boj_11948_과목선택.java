package B4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11948_과목선택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = 100;
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int n = Integer.parseInt(br.readLine());
            sum += n;
            min = Math.min(min, n);
        }
        sum -= min;

        min = 100;
        for (int i = 0; i < 2; i++) {
            int n = Integer.parseInt(br.readLine());
            sum += n;
            min = Math.min(min, n);
        }
        sum -= min;

        System.out.print(sum);
    }
}
