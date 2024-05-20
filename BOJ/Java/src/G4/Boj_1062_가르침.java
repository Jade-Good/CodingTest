package G4;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_1062_가르침 {
    private static int N, K, MAX;
    private static int[] usedChar;

    public static void main(String[] args) throws IOException {
        // Intput
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        usedChar = new int[N];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (char c : chars) {
                usedChar[i] |= (1 << c - 'a'); // 사용 된 문자 비트마스킹 : 1
            }
        }

        // a, c, i, n, t 는 반드시 읽을 줄 알아야 함
        if (K < 5) {
            bw.write("0");
            bw.flush();
            return;
        }

        int mustLearned = (1 << ('a' - 'a')) | (1 << ('c' - 'a')) | (1 << ('i' - 'a')) | (1 << ('n' - 'a')) | (1 << ('t' - 'a'));


        // Combination : K개의 문자 선택 후 읽을 수 있는 단어 수 체크
        MAX = 0;
        combination(0, mustLearned, 5);

        // Output
        bw.write(Integer.toString(MAX));
        bw.flush();
    }

    private static void combination(int start, int learned, int cnt) {
        if (cnt == K) { // K개의 문자를 골랐으면 읽을 수 있는 단어 수 확인
            MAX = Math.max(MAX, read(learned));
            return;
        }
        for (int i = start; i < 26; i++) { // 비트 마스킹 하나씩 1 만들어보기

            if ((learned & (1 << i)) == 0) { // 안배운 문자 배우기
                combination(i + 1, learned | (1 << i), cnt + 1);
            }
        }
    }

    private static int read(int learned) { // 읽을 수 있는 단어 수 세기
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if ((usedChar[i] & learned) == usedChar[i])
                cnt++;
        }
        return cnt;
    }
}
