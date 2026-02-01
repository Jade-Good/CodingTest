package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_9782_Median {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int cnt = 1;
        String s;

        while ((s = br.readLine()).length() > 1 || s.charAt(0) != '0') {
            StringTokenizer st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken());
            double[] arr = new double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Double.parseDouble(st.nextToken());
            }

            sb.append("Case ").append(cnt++);
            if (n % 2 == 1) {
                sb.append(String.format(": %.1f\n", arr[n / 2]));
            } else {
                sb.append(String.format(": %.1f\n", (arr[n / 2] + arr[n / 2 - 1]) / 2));
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
