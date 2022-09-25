package B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class boj_1247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 3; t++){
            int n = Integer.parseInt(br.readLine());
            BigInteger sum = new BigInteger("0");

            for (int i = 0; i < n; i++){
                BigInteger temp = new BigInteger(br.readLine());
                sum = sum.add(temp);
            }

            if (sum.compareTo(BigInteger.ZERO) == -1){
                System.out.println("-");
            } else if (sum.compareTo(BigInteger.ZERO) == 1) {
                System.out.println("+");
            }else
                System.out.println(0);
        }
    }
}
