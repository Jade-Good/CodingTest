import java.io.*;
import java.util.StringTokenizer;

public class Boj_25377_빵 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (a <= b)
                min = Math.min(min, b);
        }
        bw.write(Integer.toString(min == Integer.MAX_VALUE ? -1 : min));
        bw.flush();
    }
}