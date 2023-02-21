package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_6987_월드컵 {
    static int size;
    static int[] wins, draws, loses;
    static int[][] matches;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 최대 경기 가능한 경우의 수 구하기
        for (int i = 1; i < 6; i++) {
            size += i;
        }

        // 경기 매치 별 팀 별도 저장
        matches = new int[size][2];
        int index = 0;
        for (int i = 0; i < 6 - 1; i++) {
            for (int j = i + 1; j < 6; j++) {
                matches[index][0] = i;
                matches[index][1] = j;
                index++;
            }
        }

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            wins = new int[6];
            draws = new int[6];
            loses = new int[6];

            boolean flag = true;
            int w = 0, d = 0, l = 0;

            for (int j = 0; j < 6; j++) {
                w += wins[j] = Integer.parseInt(st.nextToken());
                d += draws[j] = Integer.parseInt(st.nextToken());
                l += loses[j] = Integer.parseInt(st.nextToken());
                if (wins[j] + draws[j] + loses[j] != 5)
                    flag = false;
            }

            if (flag && recursion(0))
                System.out.print(1 + " ");
            else
                System.out.print(0 + " ");
        }
    }

    private static boolean recursion(int count) { // count : 매치 번호
        if (count == size) {   // 모든 매치를 다 볼 수 있으면 가능한 매치
            return true;
        }

        int a = matches[count][0]; // a팀
        int b = matches[count][1]; // b팀

        if (wins[a] > 0 && loses[b] > 0) {  // a승, b패
            wins[a]--;
            loses[b]--;
            if (recursion(count + 1)) return true;
            wins[a]++;
            loses[b]++;
        }

        if (draws[a] > 0 && draws[b] > 0) { // a, b 무승부
            draws[a]--;
            draws[b]--;
            if (recursion(count + 1)) return true;
            draws[a]++;
            draws[b]++;
        }

        if (loses[a] > 0 && wins[b] > 0) {  // a패, b승
            loses[a]--;
            wins[b]--;
            if (recursion(count + 1)) return true;
            loses[a]++;
            wins[b]++;
        }
        return false;
    }
}