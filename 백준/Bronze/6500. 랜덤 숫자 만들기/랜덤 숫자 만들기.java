import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String a = br.readLine();

        while (!a.equals("0")) {

            Set<String> set = new HashSet<>();
            set.add(a);

            while (true) {
                int next = Integer.parseInt(a);
                a = String.format("%08d", next * next).substring(2, 6);
                if (set.contains(a)) {
                    break;
                }
                set.add(a);
            }

            sb.append(set.size()).append('\n');
            a = br.readLine();
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
