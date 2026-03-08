import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double T = Double.parseDouble(br.readLine());

        long result = Math.round((T * T) / 4.0);
        System.out.print(result);
    }
}
