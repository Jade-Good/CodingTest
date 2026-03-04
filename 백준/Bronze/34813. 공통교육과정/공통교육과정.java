import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char c = br.readLine().charAt(0);

        if (c == 'F') {
            System.out.print("Foundation");
        } else if (c == 'C') {
            System.out.print("Claves");
        } else if (c == 'V') {
            System.out.print("Veritas");
        } else if (c == 'E') {
            System.out.print("Exploration");
        }
    }
}
