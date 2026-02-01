package S5;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_11999_Milk_Pails {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = 0; i * X <= M; i++) {
            for (int j = 0; j * Y <= M - i * X; j++) {
                if (M - answer > M - (i * X + j * Y))
                    answer = i * X + j * Y;
            }
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }
}
