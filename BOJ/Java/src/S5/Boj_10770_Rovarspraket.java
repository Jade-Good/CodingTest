package S5;

import java.io.*;

public class Boj_10770_Rovarspraket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] words = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();

        for (char c : words) {
            sb.append(c);
            if (!isConsonat(c)) {
                for (int i = 1; i < 13; i++) {
                    if (c - i >= 'a' && isConsonat((char) (c - i))) {
                        sb.append((char) (c - i));
                        break;
                    } else if (c + i <= 'z' && isConsonat((char) (c + i))) {
                        sb.append((char) (c + i));
                        break;
                    }
                }
                if (!(isConsonat((char) (c + 1))))
                    sb.append((char) Math.min(c + 1, 'z'));
                else
                    sb.append((char) Math.min(c + 2, 'z'));
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isConsonat(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
