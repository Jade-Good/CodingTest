import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 2 || N == 6 || N == 8 || N == 7) {
            System.out.print("Think before submission");
        } else {
            System.out.print("Solve harder problems");
        }
    }
}