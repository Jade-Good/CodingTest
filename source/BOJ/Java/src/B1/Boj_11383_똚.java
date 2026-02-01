package B1;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_11383_똚 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] A = new char[N][M];
        char[][] AA = new char[N][M];

        for (int i = 0; i < N; i++) {
            A[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            AA[i] = br.readLine().toCharArray();
        }

        bw.write(isEyfa(A, AA) ? "Eyfa" : "Not Eyfa");
        bw.flush();
    }

    private static boolean isEyfa(char[][] A, char[][] AA) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] != AA[i][j * 2] || A[i][j] != AA[i][j * 2 + 1])
                    return false;
            }
        }

        return true;
    }
}
