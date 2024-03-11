package G5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_2166_다각형의_면적 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        double[] X = new double[N];
        double[] Y = new double[N];

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = Double.parseDouble(st.nextToken());
            Y[i] = Double.parseDouble(st.nextToken());
        }

        double sum = X[N - 1] * Y[0] - Y[N - 1] * X[0];
        for (int i = 0; i < N - 1; i++) {
            sum += X[i] * Y[i + 1];
            sum -= Y[i] * X[i + 1];
        }

        sum = (double) Math.round((Math.abs(sum) / 2.0) * 10.0) / 10.0;

        bw.write(String.format("%.1f", sum));
        bw.flush();
    }
}
