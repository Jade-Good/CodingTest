package B2;

import java.io.*;

public class Boj_1977_완전제곱수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int min = (int) Math.ceil(Math.sqrt(N));
        int sum = 0;
        for (int i = min; i * i <= M; i++) {
            sum += i * i;
        }

        if (sum == 0)
            sb.append(-1);
        else {
            sb.append(sum).append('\n');
            sb.append(min * min);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
