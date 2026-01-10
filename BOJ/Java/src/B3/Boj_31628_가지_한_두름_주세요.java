package B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_31628_가지_한_두름_주세요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] arr = new String[10][10];

        for (int i = 0; i < 10; i++) {
            arr[i] = br.readLine().split(" ");
        }

        for (int i = 0; i < 10; i++) {
            int row = 0;
            int col = 0;
            for (int j = 0; j < 9; j++) {
                if (arr[i][j].equals(arr[i][j + 1])) {
                    row++;
                }
                if (arr[j][i].equals(arr[j + 1][i])) {
                    col++;
                }
            }
            if (row == 9 || col == 9) {
                System.out.print(1);
                return;
            }
        }

        System.out.print(0);
    }
}
