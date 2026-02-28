import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            sb.append("Pairs for ").append(n).append(':').append(' ');

            for (int i = 1; i < n / 2.0; i++) {
                if (i == 1) {
                    sb.append(i).append(' ').append(n - i);
                } else {
                    sb.append(',').append(' ').append(i).append(' ').append(n - i);
                }
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
