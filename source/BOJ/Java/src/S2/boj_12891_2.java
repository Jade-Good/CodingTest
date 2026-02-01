package S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_12891_2 {
    static int[] mins, now;

    public static void test(String s) throws IOException {
        StringTokenizer st = new StringTokenizer(s);
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String string = st.nextToken();

        Map<Character, Integer> index = new HashMap<>();
        index.put('A', 0);
        index.put('C', 1);
        index.put('G', 2);
        index.put('T', 3);

        mins = new int[4];
        now = new int[4];

        for (int i = 0; i < 4; i++) {
            mins[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < P; i++) {
            now[index.get(string.charAt(i))]++;
        }

        int answer = check() ? 1 : 0;

        for (int i = 1; i <= S - P; i++) { // i : 윈도우의 시작 인덱스
            now[index.get(string.charAt(i - 1))]--;
            now[index.get(string.charAt(i + P - 1))]++;
            if (check())
                answer++;
        }
        System.out.println(answer);
    }

    private static boolean check() {
        for (int i = 0; i < 4; i++) {
            if (mins[i] > now[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String string = br.readLine();

        Map<Character, Integer> index = new HashMap<>();
        index.put('A', 0);
        index.put('C', 1);
        index.put('G', 2);
        index.put('T', 3);

        mins = new int[4];
        now = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            mins[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < P; i++) {
            now[index.get(string.charAt(i))]++;
        }

        int answer = check() ? 1 : 0;

        for (int i = 1; i <= S - P; i++) { // i : 윈도우의 시작 인덱스
            now[index.get(string.charAt(i - 1))]--;
            now[index.get(string.charAt(i + P - 1))]++;
            if (check())
                answer++;
        }
        System.out.println(answer);
    }
}
