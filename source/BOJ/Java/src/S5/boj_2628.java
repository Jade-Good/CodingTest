package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 0)
                row.add(Integer.parseInt(st.nextToken()));
            else
                col.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(row);
        Collections.sort(col);

        int answer = 0;
        int x = 0, y = 0;
        for (int i = 0; i <= row.size(); i++){
            int xx = 0, yy;
            for (int j = 0; j <= col.size(); j++){
                if (i == row.size()){
                    xx = c;
                }else xx = row.get(i);
                if (j == col.size()){
                    yy = r;
                }else yy = col.get(j);

                int temp = (xx-x)*(yy-y);
                if (temp > answer) answer = temp;

                if (j != c)
                    y = yy;
            }
            y = 0;
            if (i != r)
                x = xx;
        }
        System.out.println(answer);
    }
}
