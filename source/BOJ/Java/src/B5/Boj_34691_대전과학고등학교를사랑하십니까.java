package B5;

import java.io.*;

public class Boj_34691_대전과학고등학교를사랑하십니까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String S;

        while (!(S = br.readLine()).equals("end")) {
            if (S.charAt(0) == 'a') sb.append("Panthera tigris\n");
            else if (S.charAt(0) == 't') sb.append("Pinus densiflora\n");
            else if (S.charAt(0) == 'f') sb.append("Forsythia koreana\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
