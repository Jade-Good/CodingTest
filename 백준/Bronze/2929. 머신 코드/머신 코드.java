import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        int orderCnt = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= 'Z' && (i + orderCnt) % 4 != 0) {
                orderCnt += 4 - (i + orderCnt) % 4;
            }
        }

        System.out.print(orderCnt);
    }
}
