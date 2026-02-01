package P5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_14865_곡선_자르기 {
    public static void main(String[] args) throws IOException {
        // 1) 정보 입력받기
        // 값의 범위가 크므로 배열로 나타낼 수 없음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] input = new long[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            input[i][0] = Long.parseLong(st.nextToken());
            input[i][1] = Long.parseLong(st.nextToken());
        }

        // 2) 봉우리 좌표 저장하기 (y가 0 초과인 경우만 x축 저장)
        ArrayList<Pair> bongs = new ArrayList<>();
        boolean flag = false;
        long temp = 0;

        for (int i = 0; i < n; i++) {
            if (!flag && input[i][1] > 0) {     // x축 아래에서 위로 올라갈 때
                flag = true;
                temp = input[i][0];
            } else if (flag && input[i][1] < 0) {  // x축 위에서 아래로 내려갈 때
                bongs.add(new Pair(Math.min(temp, input[i][0]), Math.max(temp, input[i][0])));
                flag = false;
            }
        }

        Collections.sort(bongs);

        // 출력 : 봉우리 좌표 잘 들어감!
//		for (Pair pair : bongs) {
//			System.out.println(pair.left + " " + pair.right);
//		}

        // 3) 봉우리 세기 (포함 경우 구분)
        long a = bongs.size(); // 다른 봉우리에 의해 포함되지 않음
        long b = bongs.size(); // 다른 봉우리를 포함하지 않음

        for (int i = 0; i < bongs.size(); i++) {
            long left = bongs.get(i).left;
            long right = bongs.get(i).right;

            for (int j = 0; j < i; j++) { // 다른 봉우리에 포함 됨
                if (bongs.get(j).left < left && right < bongs.get(j).right) {
                    a--;
                    break;
                }
            }

            for (int j = i + 1; j < bongs.size(); j++) {
                if (bongs.get(j).left > right) {
                    break;
                }
                if (bongs.get(j).right < right) {// 다른 봉우리를 포함 함
                    b--;
                    break;
                }
            }
        }


        // 출력
        System.out.println(a + " " + b);
    }

    private static class Pair implements Comparable<Pair> {
        long left, right;

        public Pair(long left, long right) {
            super();
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Pair o) {
            return Long.compare(this.left, o.left);
        }
    }
}
