package B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_17093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Pair> nl = new ArrayList<>();
        ArrayList<Pair> ml = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nl.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            ml.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        long answer = 0;
        for (int i = 0; i < m; i++){
            long rr = 0;
            for (int j = 0; j < n; j++){
                long temp = (long)(Math.pow(nl.get(j).x - ml.get(i).x, 2) + Math.pow(nl.get(j).y - ml.get(i).y, 2));
                if (temp > rr) {
                    rr = temp;
                }
            }
            if (rr > answer){
                answer = rr;
            }
        }
        System.out.println(answer);
    }
}

class Pair {
    int x,y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
