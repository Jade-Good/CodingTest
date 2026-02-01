package B2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Boj_5576_콘테스트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 2; i++) {

            int[] arr = new int[10];

            for (int j = 0; j < 10; j++) {
                arr[j] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            int sum = 0;

            for (int j = 9; j >= 7; j--) {
                sum += arr[j];
            }
            sb.append(sum).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
