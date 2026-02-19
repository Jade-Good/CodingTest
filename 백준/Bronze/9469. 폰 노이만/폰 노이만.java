
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int P = Integer.parseInt(br.readLine());

        for (int p = 0; p < P; p++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            double D = Double.parseDouble(st.nextToken());
            double A = Double.parseDouble(st.nextToken());
            double B = Double.parseDouble(st.nextToken());
            double F = Double.parseDouble(st.nextToken());
            sb.append(N).append(' ').append(D / (A + B) * F).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}