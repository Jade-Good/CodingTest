package G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_15686 {
    static ArrayList<Pair> home, chicken;
    static boolean[] open;
    static int n, m, answer;

    public static void test(String s) throws IOException {
        //input
        StringTokenizer st = new StringTokenizer(s);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        chicken = new ArrayList<>();
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1)
                    home.add(new Pair(i, j));
                else if (input == 2)
                    chicken.add(new Pair(i, j));
            }
        }

        open = new boolean[chicken.size()];

        // 본 계산 (부분 집합 + 완전탐색)
        subset(0, 0);

        System.out.println(answer);
    }

    private static void subset(int count, int open_count) { // 치킨집의 부분집합, count : 현재까지 처리한 원소 수
        if (count == chicken.size()) {
            if (open_count <= m)
                city_chicken_distance();
        } else {
            open[count] = true;
            subset(count + 1, open_count+1);
            open[count] = false;
            subset(count + 1, open_count);
        }
    }

    private static void city_chicken_distance() {
        int sum = 0; //임시 도시의 치킨 거리
        for (int i = 0; i < home.size(); i++) { // 집들
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < chicken.size(); j++) { // 치킨집들
                if (open[j]) { // 열려있는 치킨 가게
                    min = Math.min(min, distance(home.get(i), chicken.get(j))); // 더 가까운 치킨집 거리 저장
                }
            }
            if (min < Integer.MAX_VALUE) { // 더 가까운 치킨집 거리를 찾았으면
                sum += min;
            }
        }
        if (sum > 0 && sum < answer) // 거리를 1번이라도 계산해야하고, 지금까지 거리보다 더 가까우면 도시 치킨 거리 업데이트
            answer = sum;
    }

    private static int distance(Pair a, Pair b) {
        return Math.abs(a.row - b.row) + Math.abs(a.col - b.col);
    }

    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        chicken = new ArrayList<>();
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1)
                    home.add(new Pair(i, j));
                else if (input == 2)
                    chicken.add(new Pair(i, j));
            }
        }

        open = new boolean[chicken.size()];

        // 본 계산 (부분 집합 + 완전탐색)
        subset(0, 0);

        System.out.println(answer);
    }

    private static class Pair {
        int row, col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
