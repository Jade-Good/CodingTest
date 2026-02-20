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

        int N = Integer.parseInt(br.readLine());

        String large = "@".repeat(3 * N);
        String small = "@".repeat(N);
        String space = " ".repeat(N);

        for (int i = 0; i < N; i++) {
            sb.append(large);
            sb.append(space);
            sb.append(small);
            sb.append('\n');
        }
        for (int i = 0; i < 3 * N; i++) {
            sb.append(small);
            sb.append(space);
            sb.append(small);
            sb.append(space);
            sb.append(small);
            sb.append('\n');
        }
        for (int i = 0; i < N; i++) {
            sb.append(small);
            sb.append(space);
            sb.append(large);
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
