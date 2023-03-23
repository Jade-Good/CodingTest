package B4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11365_밀비_급일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuffer stringBuffer = null;
        String str = null;
        while (!(str=br.readLine()).equals("END")) {
            stringBuffer = new StringBuffer(str);
            sb.append(stringBuffer.reverse().toString()).append('\n');
        }
        System.out.println(sb);
    }
}
