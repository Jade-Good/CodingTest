package B4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_15680_연세대학교 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (Integer.parseInt(br.readLine()) == 0) {
            System.out.print("YONSEI");
        } else {
            System.out.print("Leading the Way to the Future");
        }
    }
}
