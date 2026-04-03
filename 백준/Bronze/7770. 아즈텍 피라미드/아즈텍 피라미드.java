import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long sum = 0;
        int h = 0;

        for (int i = 1; ; i++) {
            long currentLayerBlocks = (long) i * i + (long) (i - 1) * (i - 1);
            sum += currentLayerBlocks;

            if (sum > n) {
                break;
            }
            h++;
        }

        System.out.print(h);
    }
}
