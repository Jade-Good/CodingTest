package B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2704 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] ss;

        for (int i = 0; i < n; i++) {
            ss = br.readLine().split(":");

            for (int j = 0; j < 3; j++) {
                ss[j] = String.format("%6s",Integer.toBinaryString(Integer.parseInt(ss[j]))).replaceAll(" ","0");
            }
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.print(ss[k].charAt(j));
                }
            }
            System.out.print(" ");
            for (int j = 0; j < 3; j++){
                System.out.print(ss[j]);
            }
            System.out.println("");
        }
    }
}
