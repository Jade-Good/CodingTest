import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], '.');
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int h = Integer.parseInt(st.nextToken());
            for (int j = N - h; j < N; j++) {
                map[j][i] = '#';
            }
        }

        for (int i = 0; i < M; i++) {
            if (map[N - X][i] == '#') {
                map[N - X][i] = '*';
            } else {
                map[N - X][i] = '-';
            }
        }

        for (int i = 2; i < M; i += 3) {
            for (int j = N - X + 1; j < N; j++) {
                if (map[j][i] == '.') {
                    map[j][i] = '|';
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
