import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] chars;
        while ((chars = br.readLine().toCharArray()).length > 1) {
            int sum = 0;
            for (int i = 2; i < chars.length; i++) {
                if (chars[0] == chars[i] || chars[0] - 32 == chars[i]) {
                    sum++;
                }
            }
            sb.append(chars[0]).append(' ').append(sum).append('\n');
        }
        System.out.print(sb);
    }
}
