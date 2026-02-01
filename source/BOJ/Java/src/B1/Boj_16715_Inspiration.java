package B1;

import java.io.*;

public class Boj_16715_Inspiration {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N  = Integer.parseInt(br.readLine());
        int max = 0;
        int jari = -1;

        for (int i = 2; i <= N; i++) {
            int sum = 0;
            int num = N;

            while(num > 0) {
                sum += num % i;
                num /= i;
            }

            if (sum > max) {
                max = sum;
                jari = i;
            }
        }

        sb.append(max).append(' ').append(jari);
        bw.write(sb.toString());
        bw.flush();
    }
}
