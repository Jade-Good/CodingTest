package G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_17406 {
    private static int n, m, k, ansMin;
    private static int[][] arr, temp;
    private static Order[] orders, result;
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ansMin = Integer.MAX_VALUE;

        arr = new int[n][m];
        orders = new Order[k];
        result = new Order[k];
        used = new boolean[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            orders[i] = new Order(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
        }

        // permutation
        perm(0);

        // output
        System.out.println(ansMin);
    }

    private static void np() {
        
    }

    private static void perm(int idx) {         // 순열로 k개의 연산 순서바꿔서 써보기
        if (idx == k) {
            // temp <- arr 복사
            temp = new int[n][m];
            for(int i = 0; i < n; i++){ // 반복문 + ArrayCopy
                System.arraycopy(arr[i], 0, temp[i], 0, m);
            }
//            for (int l = 0; l < n; l++) {
//                for (int j = 0; j < m; j++) {
//                    temp[l][j] = arr[l][j];
//                }
//            }

            for (int i = 0; i < k; i++) {
                rotate(result[i]);
            }
            cal_arr();
            return;
        }

        for (int i = 0; i < k; i++) {
            if (used[i]) continue;
            used[i] = true;
            result[idx] = orders[i];
            perm(idx + 1);
            used[i] = false;
        }
    }



    private static void rotate(Order order) {   // 연산 실행
        int[] dx = {1, 0, -1, 0}; // 하 우 상 좌
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < order.s; i++) {
            int r = order.r - order.s + i;
            int c = order.c - order.s + i;
            int tmp = temp[r][c];

            for (int j = 0; j < 4; j++) { // dx dy
                for (int l = 0; l < (order.s-i)*2; l++) { // 한 변의 이동 진행
                    temp[r][c] = temp[r+dx[j]][c+dy[j]];
                    r += dx[j];
                    c += dy[j];
                }
            }
            temp[order.r - order.s + i][order.c - order.s + i + 1] = tmp;      // 덮어 써진 처음 값 따로 써주기
        }
    }

    private static void cal_arr() {             // '배열 값' 계산
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = 0; j < m; j++) {
                tmp += temp[i][j];
            }
            ansMin = Math.min(ansMin, tmp);
        }
    }

    private static class Order {                // 연산 정보를 저장할 클래스
        int r, c, s;

        public Order(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
}
