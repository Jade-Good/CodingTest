package D0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ssafy_b_3_No1_새로운_불면증_치료법_bitmasking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            int bitmask = 0;
            int n = Integer.parseInt(br.readLine());
            int com = 1;

            while (bitmask < 1023) {
                int temp = n * com;
                while (temp > 0) {
                    int idx = temp % 10;
                    bitmask = bitmask | (1 << idx);
                    temp /= 10;
                }
                com++;
            }
            sb.append('#').append(t).append(' ').append(n * --com).append('\n');
        }
        System.out.println(sb);
    }
}
