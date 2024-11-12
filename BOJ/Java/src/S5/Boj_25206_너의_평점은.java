package S5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_25206_너의_평점은 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;
        double result = 0;
        double sum = 0;

        while((s = br.readLine()) != null && s.length() > 2) {
            StringTokenizer st = new StringTokenizer(s);
            st.nextToken();
            double point = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) {
                continue;
            }

            sum += point;

            switch (grade) {
                case "A+":
                    point *= 4.5;
                    break;
                case "A0":
                    point *= 4.0;
                    break;
                case "B+":
                    point *= 3.5;
                    break;
                case "B0":
                    point *= 3.0;
                    break;
                case "C+":
                    point *= 2.5;
                    break;
                case "C0":
                    point *= 2.0;
                    break;
                case "D+":
                    point *= 1.5;
                    break;
                case "D0":
                    point *= 1.0;
                    break;
                case "F":
                    point *= 0.0;
                    break;
            }

            result += point;
        }

        bw.write(Double.toString(result / sum));
        bw.flush();
    }
}
