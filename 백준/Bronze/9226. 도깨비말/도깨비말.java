import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String S;

        while (!(S = br.readLine()).equals("#")) {
            int idx = -1;
            char[] chars = S.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if ("aeiou".indexOf(chars[i]) != -1) {
                    idx = i;
                    break;
                }
            }

            if (idx > -1) {
                for (int i = idx; i < chars.length; i++) {
                    sb.append(chars[i]);
                }
                for (int i = 0; i < idx; i++) {
                    sb.append(chars[i]);
                }
                sb.append("ay\n");
            } else {
                sb.append(S).append("ay\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
