package G5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_27172_수_나누기_게임 {

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        boolean[] isNum = new boolean[1_000_001];
        int max = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            max = Math.max(cards[i], max);
            isNum[cards[i]] = true;
        }

        int[] points = new int[max + 1];

        // 수 나누기 게임
        for (int i = 0; i < N; i++) {
            for (int j = 2; cards[i] * j <= max; j++) {
                if (isNum[cards[i] * j]) {
                    points[cards[i]]++;
                    points[cards[i] * j]--;
                }
            }
        }

        // 출력
        for (int i = 0; i < N; i++) {
            sb.append(points[cards[i]]).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
