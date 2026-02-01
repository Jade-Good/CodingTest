package B1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_18125_고양이_사료 {
    private static String s1 = "|>___/|     /}\n"
            + "| O O |    / }\n"
            + "( =0= )\"\"\"\"  \\\n"
            + "| ^  ____    |\n"
            + "|_|_/    ||__|";
    private static String s2 = "|>___/|        /}\n"
            + "| O < |       / }\n"
            + "(==0==)------/ }\n"
            + "| ^  _____    |\n"
            + "|_|_/     ||__|";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] v1 = new int[C][R];
        int[][] v2 = new int[R][C];

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < R; j++) {
                v1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                v2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(match(v1, v2) ? s2 : s1);
        bw.flush();
    }

    private static boolean match(int[][] v1, int[][] v2) {
        for (int i = 0; i < v1.length; i++) {
            for (int j = 0; j < v2.length; j++) {
                if (v1[i][j] != v2[j][v1.length - 1 - i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
