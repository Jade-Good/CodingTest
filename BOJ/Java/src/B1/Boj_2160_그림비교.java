package B1;

import java.io.*;

public class Boj_2160_그림비교 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][][] arr = new char[N][5][7];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                char[] chars = br.readLine().toCharArray();
                for (int k = 0; k < 7; k++) {
                    arr[i][j][k] = chars[k];
                }
            }
        }

        int min = 36;
        String result = "";

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int cnt = 0;
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 7; l++) {
                        if (arr[i][k][l] != arr[j][k][l]) cnt++;
                    }
                }
                if (min > cnt) {
                    min = cnt;
                    result = (i + 1) + " " + (j + 1);
                }
            }
        }

        bw.write(result);
        bw.flush();
    }
}
