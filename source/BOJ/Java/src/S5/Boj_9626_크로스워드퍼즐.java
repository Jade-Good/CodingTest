package S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_9626_크로스워드퍼즐 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int U = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        char[][] result = new char[M + U + D][N + L + R];
        boolean flag = true;

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j ++) {
                if (j % 2 == 0) result[i][j] = flag ? '#' : '.';
                else result[i][j] = flag ? '.' : '#';
            }
            flag = !flag;
        }

        for (int i = U; i < U + M; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = L; j < L + N; j++) {
                result[i][j] = arr[j - L];
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                sb.append(result[i][j]);
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
