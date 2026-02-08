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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sb.append('S').append('N').append(' ').append(N);

        if (M <= 26) {
            sb.append((char) (M + 'A' - 1));
        } else {
            M -= 27;
            sb.append((char) ((M / 26) + 'a')).append((char) ((M % 26) + 'a'));
        }

        bw.write(sb.toString());
        bw.flush();
    }
}