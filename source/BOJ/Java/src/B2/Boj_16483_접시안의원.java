package B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_16483_접시안의원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double T = Double.parseDouble(br.readLine());

        long result = Math.round((T * T) / 4.0);
        System.out.print(result);
    }
}
