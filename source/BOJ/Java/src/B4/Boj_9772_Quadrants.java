package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_9772_Quadrants {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double X = Double.parseDouble(st.nextToken());
            double Y = Double.parseDouble(st.nextToken());

            if (X == 0 || Y == 0) {
                sb.append("AXIS\n");
            } else if (X > 0) {
                sb.append(Y > 0 ? "Q1\n" : "Q4\n");
            } else {
                sb.append(Y > 0 ? "Q2\n" : "Q3\n");
            }

            if (X == 0 && Y == 0) {
                break;
            }

        }

        bw.write(sb.toString());
        bw.flush();
    }
}
