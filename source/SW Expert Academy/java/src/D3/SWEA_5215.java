package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {
    static int N,L,ansMax;
    static Ingredient[] ingredients;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            ingredients = new Ingredient[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                ingredients[i] = new Ingredient(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
            
            ansMax = 0;

            subset(0, 0, 0);

            System.out.println("#" + t + " " + ansMax);
        }
    }
    
    private static void subset(int idx, int tsum, int csum) {
        if (csum > L)
            return;

        if (idx == N) {
            ansMax = Math.max(ansMax, tsum);
            return;
        }

        subset(idx+1, tsum+ingredients[idx].taste,
                csum+ingredients[idx].calorie);
        subset(idx+1, tsum, csum);
    }

    private static class Ingredient {
        int taste, calorie;

        public Ingredient(int taste, int calorie) {
            this.taste = taste;
            this.calorie = calorie;
        }
    }
}
