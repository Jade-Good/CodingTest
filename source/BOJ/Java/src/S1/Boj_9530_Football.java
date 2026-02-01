package S1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_9530_Football {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        int[][] matches = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matches[i][0] = Integer.parseInt(st.nextToken());
            matches[i][1] = Integer.parseInt(st.nextToken());
        }

        int total = 0;
        List<Integer> needGoals = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (matches[i][0] > matches[i][1]) {
                total += 3;
            } else if (matches[i][0] == matches[i][1]) {
                total += 1;
                needGoals.add(1);
            } else {
                needGoals.add(matches[i][1] - matches[i][0] + 1);
            }
        }

        Collections.sort(needGoals);

        for (int goals : needGoals) {
            if (G >= goals) { // 승리 가능
                if (goals == 1) {
                    total += 2; // 무승부 -> 승리
                } else {
                    total += 3; // 패배 -> 승리
                }
                G -= goals;
            } else if (goals > 1 && G >= goals - 1) { // 패배 -> 무승부
                total += 1;
                G -= (goals - 1);
            }
            if (G <= 0) {
                break;
            }
        }
        bw.write(Integer.toString(total));
        bw.flush();
    }
}
