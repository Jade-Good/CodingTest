package B5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_31429_SUAPC_2023_Summer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[][] score = {{12, 1600}, {11, 894}, {11, 1327}, {10, 1311}, {9, 1004},
                {9, 1178}, {9, 1357}, {8, 837}, {7, 1055}, {6, 556}, {6, 773}};

        int N = Integer.parseInt(br.readLine()) - 1;
        sb.append(score[N][0]).append(' ').append(score[N][1]);

        bw.write(sb.toString());
        bw.flush();
    }
}