package B2;

import java.math.BigInteger;
import java.util.Scanner;

public class Boj_19946_2의제곱수계산하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger bi = new BigInteger(sc.next());

        for (int i = 64; i >= 0; i--) {
            if (bi.mod(BigInteger.TWO).equals(BigInteger.ONE)) {
                System.out.print(i);
                break;
            } else {
                bi = bi.divide(BigInteger.TWO);
            }
        }
    }
}
