import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (num / 10 > 0) {

            cnt++;
            int next = 1;

            while (num > 0) {
                next *= num % 10;
                num /= 10;
            }

            num = next;
        }

        System.out.print(cnt);
    }
}
