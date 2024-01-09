package G5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1759_암호_만들기 {
    private static StringBuilder sb;
    private static char[] chars, selelcted;
    private static char[] mo = {'a', 'e', 'i', 'o', 'u'};
    private static int L, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        chars = new char[C];
        selelcted = new char[L];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chars);
        permutation(0, 0);

        bw.write(sb.toString());
        bw.flush();
    }

    private static void permutation(int start, int cnt) {
        if (cnt == L) {
            check();
            return;
        }
        
        for (int i = start; i < C; i++) {
            selelcted[cnt] = chars[i];
            permutation(i + 1, cnt + 1);
        }
    }

    private static void check() {
        int mc = 0;
        for (int i = 0; i < L; i++) {
            for (char m : mo) {
                if (m == selelcted[i]) {
                    mc++;
                }
            }
        }

        if (mc >= 1 && L - mc >= 2) {
            sb.append(String.valueOf(selelcted)).append('\n');
        }
    }
}
