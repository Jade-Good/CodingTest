import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int Y = sc.nextInt();

        System.out.print(repunit(X) + repunit(Y));
    }

    private static int repunit(int K) {
        int result = 1;

        for (int i = 1; i < K; i++) {
            result = result * 10 + 1;
        }

        return result;
    }
}
