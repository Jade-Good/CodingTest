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
        char[][] result = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                if (c != '.') {
                    result[i][j] = c;
                    result[i][M - j - 1] = c;
                } else if (result[i][j] == '\0') {
                    result[i][j] = c;
                }
            }
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j]);
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
