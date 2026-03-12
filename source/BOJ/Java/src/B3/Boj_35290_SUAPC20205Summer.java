package B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_35290_SUAPC20205Summer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 2 || N == 6 || N == 7 || N == 8) {
            System.out.print("Think before submission");
        } else {
            System.out.print("Solve harder problems");
        }
    }
}