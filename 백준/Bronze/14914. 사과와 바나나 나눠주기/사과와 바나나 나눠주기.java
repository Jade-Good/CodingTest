import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int max = Math.min(a, b);

        for (int i = 1; i <= max; i++) {
            if (a % i == 0 && b % i == 0) {
                sb.append(i).append(' ').append(a / i).append(' ').append(b / i).append('\n');
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
