package B3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_9493_길면기차기차는빨라빠른것은비행기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            double M = Double.parseDouble(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (M == 0) {
                break;
            }

            double a = M / A;
            double b = M / B;
            double diff = Math.abs(a - b);
            long totalSeconds = Math.round(diff * 3600);

            long h = totalSeconds / 3600;
            long m = (totalSeconds % 3600) / 60;
            long s = totalSeconds % 60;

            sb.append(h).append(':').append(String.format("%02d", m)).append(':').append(String.format("%02d", s))
                    .append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
