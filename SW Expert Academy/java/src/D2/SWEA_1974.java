package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            boolean flag = false;
            boolean[] check;
            int[][] arr = new int[10][10];

            for (int j = 0; j < 9; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 9; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < 9; j++) {
                check = new boolean[10];
                for (int k = 0; k < 9; k++) {
                    if (!check[arr[j][k]])
                        check[arr[j][k]] = true;
                    else {
                        System.out.printf("#%d 0\n", i+1);
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
            if (flag) continue;

            for (int j = 0; j < 9; j++) {
                check = new boolean[10];
                for (int k = 0; k < 9; k++) {
                    if (!check[arr[k][j]])
                        check[arr[k][j]] = true;
                    else {
                        System.out.printf("#%d 0\n", i+1);
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
            
            if (flag) continue;

            for (int j = 0; j < 3; j++) {
                check = new boolean[10];
                for (int k = j*3; k < j*3+3; k++) {
                    for (int l = j*3; l < j*3+3; l++) {
                        if (!check[arr[k][l]])
                            check[arr[k][l]] = true;
                        else {
                            System.out.printf("#%d 0\n", i+1);
                            flag = true;
                            break;
                        }
                    }
                    if (flag) break;
                }
                if (flag) break;
            }
            if (!flag) {
                System.out.printf("#%d 1\n", i+1);
            }
        }
    }
}
